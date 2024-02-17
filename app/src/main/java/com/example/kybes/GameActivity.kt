package com.example.kybes
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    private var playerTotalScore = 0
    private var computerTotalScore = 0
    private var currentRound = 1

    private lateinit var textPlayerScore: TextView
    private lateinit var textComputerScore: TextView
    private lateinit var textRoundNumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        textPlayerScore = findViewById(R.id.text_player_score)
        textComputerScore = findViewById(R.id.text_computer_score)
        textRoundNumber = findViewById(R.id.text_round_number)


        val rollDiceButton = findViewById<Button>(R.id.btn_roll_dice)
        rollDiceButton.setOnClickListener {

            playRound()
        }
    }

    private fun playRound() {

        val playerDice1 = (1..6).random()
        val playerDice2 = (1..6).random()
        val computerDice1 = (1..6).random()
        val computerDice2 = (1..6).random()


        playerTotalScore += playerDice1 + playerDice2
        computerTotalScore += computerDice1 + computerDice2


        updateScores()


        if (currentRound < 3) {
            currentRound++
            textRoundNumber.text = "Раунд: $currentRound"
        } else {

            determineWinner()
        }
    }


    private fun updateScores() {
        textPlayerScore.text = "Ваши очки: $playerTotalScore"
        textComputerScore.text = "Очки компьютера: $computerTotalScore"
    }


    private fun determineWinner() {
        val playerName = findViewById<EditText>(R.id.edit_player_name).text.toString()
        val winner = when {
            playerTotalScore > computerTotalScore -> playerName
            playerTotalScore < computerTotalScore -> "Компьютер"
            else -> "Ничья"
        }
        val message = "Победил $winner! Хотите сыграть ещё раз?"

        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("Да") { dialog, _ ->
                resetGame()
                dialog.dismiss()
            }
            .setNegativeButton("Нет") { dialog, _ ->
                finish()
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }

    private fun resetGame() {
        playerTotalScore = 0
        computerTotalScore = 0
        currentRound = 1
        textRoundNumber.text = "Раунд: $currentRound"
        updateScores()
    }
}
