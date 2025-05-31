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

    override fun onResume() {
        super.onResume()

        val preferences = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
        val cor = preferences.getString("cor", "")

        if (cor!!.isNotEmpty()) {
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
    }
    
    private fun salvarCor(cor: String){
        binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor));

        binding.btnTrocar.setOnClickListener(){ view ->

            val preferences = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE);
            val editor = preferences.edit();
            editor.putString("cor",cor);
            editor.apply();

            snackBar(view);
        }
    }

    private fun snackBar(view: View){

        val snackBar = Snackbar.make(view , "Cor de fundo alterada!" , Snackbar.LENGTH_INDEFINITE);
        snackBar.setAction("OK"){}

        snackBar.setActionTextColor(Color.BLUE);
        snackBar.setBackgroundTint(Color.LTGRAY);
        snackBar.setTextColor(Color.GREEN);
        snackBar.show();
    }
}
