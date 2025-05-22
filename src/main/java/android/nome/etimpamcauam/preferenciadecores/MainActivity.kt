package android.nome.etimpamcauam.preferenciadecores

import android.app.Activity
import android.graphics.Color
import android.nome.etimpamcauam.preferenciadecores.databinding.ActivityMainBinding
import android.os.Bundle

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    //SLIDE25

    private var cor = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide();
        window.statusBarColor = Color.WHITE;
        binding = ActivityMainBinding.inflate(layoutInflater);

        setContentView(binding.root);

        binding.cor1.setOnClickListener{
            cor = "#FDAE07"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }

        binding.cor2.setOnClickListener{cor = "#0772FD"}
        binding.cor3.setOnClickListener{cor = "#CC07FD"}
        binding.cor4.setOnClickListener{cor = "#FD070F"}
        binding.cor5.setOnClickListener{cor = "#07FD07"}
    }
}