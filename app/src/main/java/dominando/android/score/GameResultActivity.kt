package dominando.android.score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class GameResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_result)

        val result = intent.getStringExtra("result")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = result
    }
}