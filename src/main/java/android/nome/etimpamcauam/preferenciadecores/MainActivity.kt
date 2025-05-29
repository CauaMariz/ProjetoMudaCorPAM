package android.nome.etimpamcauam.preferenciadecores

import android.app.Activity
import android.content.SharedPreferences
import android.graphics.Color
import android.nome.etimpamcauam.preferenciadecores.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var preferences: SharedPreferences;
    lateinit var binding : ActivityMainBinding

    //SLIDE43

    companion object{
        const val NOME_ARQUIVO = "arquivo_prefs.xml";
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater);

        setContentView(binding.root);
        var cor = "";
        binding.cor1.setOnClickListener{
            cor = "#FDAE07"
            salvarCor(cor);
        }
        binding.cor2.setOnClickListener{
            cor = "#0772FD"
            salvarCor(cor);}
        binding.cor3.setOnClickListener{
            cor = "#CC07FD"
            salvarCor(cor);}
        binding.cor4.setOnClickListener{
            cor = "#FD070F"
            salvarCor(cor);}
        binding.cor5.setOnClickListener{
            cor = "#07FD07"
            salvarCor(cor);}
    }

    private fun salvarCor(cor: String){
        binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor));

        binding.btnTrocar.setOnClickListener(){

            val preferences = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE);
            val editor = preferences.edit();
            editor.putString("cor",cor);
            editor.apply();

            Toast.makeText(this, "Cor salva no arquivo de cores", Toast.LENGTH_SHORT).show()
        }
    }
}
