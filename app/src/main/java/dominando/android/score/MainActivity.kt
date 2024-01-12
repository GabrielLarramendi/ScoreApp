package dominando.android.score

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonPlusA = findViewById<Button>(R.id.buttonPlusA)
        val buttonMinusA = findViewById<Button>(R.id.buttonMinusA)
        val buttonPlusB = findViewById<Button>(R.id.buttonPlusB)
        val buttonMinusB = findViewById<Button>(R.id.buttonMinusB)
        var scoreA = findViewById<TextView>(R.id.scoreTimeA)
        var scoreB = findViewById<TextView>(R.id.scoreTimeB)
        val buttonEndGame = findViewById<Button>(R.id.endGameButton)
        val buttonZerar = findViewById<Button>(R.id.buttonZerar)

        var textViewAToInt = scoreA.text.toString().toInt()
        var textViewBToInt = scoreB.text.toString().toInt()

        var textViewNameTeamA = findViewById<TextView>(R.id.timeAtextView)
        var textViewNameTeamB = findViewById<TextView>(R.id.timeBTextView)

        textViewNameTeamA.text = intent.getStringExtra("nameTeamA").toString()
        textViewNameTeamB.text = intent.getStringExtra("nameTeamB").toString()

        var result: String?

        buttonPlusA.setOnClickListener {
            textViewAToInt += 1
            scoreA.text = textViewAToInt.toString()
        }

        buttonMinusA.setOnClickListener {
            if (textViewAToInt == 0) {
                scoreA.text = "0"
            }
            else {
                textViewAToInt -= 1
                scoreA.text = textViewAToInt.toString()
            }
        }

        buttonPlusB.setOnClickListener {
            textViewBToInt += 1
            scoreB.text = textViewBToInt.toString()
        }

        buttonMinusB.setOnClickListener {
            if (textViewBToInt == 0) {
                scoreB.text = "0"
            }
            else {
                textViewBToInt -= 1
                scoreB.text = textViewBToInt.toString()
            }
        }

        buttonZerar.setOnClickListener {
            scoreA.text = "0"
            scoreB.text = "0"
            textViewAToInt = 0
            textViewBToInt = 0
        }

        buttonEndGame.setOnClickListener {
            val intent = Intent(this, GameResultActivity::class.java)

            if (textViewAToInt > textViewBToInt) {
                result = "Vencedor: ${textViewNameTeamA.text}"
            } else if (textViewAToInt < textViewBToInt) {
                result = "Vencedor: ${textViewNameTeamB.text}"
            } else {
                result = "EMPATE"
            }
            intent.putExtra("result", result)
            startActivity(intent)
        }
    }
}