package dominando.android.score

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ChooseTeamNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_team_name)

        var editTextTeamA = findViewById<EditText>(R.id.editTextTeamA)
        var editTextTeamB = findViewById<EditText>(R.id.editTextTeamB)
        val buttonStartGame = findViewById<Button>(R.id.buttonStartGame)

        buttonStartGame.setOnClickListener {
            if (editTextTeamA.text.toString().trim().isEmpty() || editTextTeamB.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Preencha os dois campos!", Toast.LENGTH_SHORT).show()
            } else {
                var nameTeamA = editTextTeamA.text.toString()
                var nameTeamB = editTextTeamB.text.toString()

                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("nameTeamA", nameTeamA)
                intent.putExtra("nameTeamB", nameTeamB)
                startActivity(intent)
                onPause()
                onStop()
            }

        }
    }
}