package com.rad21.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.rad21.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        binding.btn1.setOnClickListener {
            replaceFragment(Fragment_1())
        }

        binding.btn2.setOnClickListener {
            replaceFragment(Fragment_2())
        }

        tv = findViewById(R.id.textView2)

        val userName = intent.getParcelableExtra<User>("User")?.userName
        val password = intent.getParcelableExtra<User>("User")?.password
        tv.text = "Username $userName and Password $password"


        val btnImpicit: Button = findViewById(R.id.btn_implicit)
        btnImpicit.setOnClickListener(this)

    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(com.google.android.material.R.id.fragment_container_view_tag, fragment)
        fragmentTransaction.commit()

    }




    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_implicit -> {
//                val message = "Hallo Tes"
//                val intent = Intent()
//                intent.action = Intent.ACTION_SEND
//                intent.putExtra(Intent.EXTRA_TEXT, message)
//                intent.type = "text/plain"
//                startActivity(intent)

                val intent = Intent()
                intent.putExtra("history", "Anda Sudah Login")
                setResult(RESULT_OK, intent)
                finish()
            }

        }
    }
}