package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Patterns
import android.view.Menu
import android.view.MenuItem
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
//import android.widget.*
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener,
    CompoundButton.OnCheckedChangeListener {
    var textgender:String?=null
    lateinit var binding:ActivityMainBinding

    val Hobbies:ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSubmit.setOnClickListener {
            val fname = binding.FirstName.editText!!.text.toString()
            val lName = binding.LastName.editText!!.text.toString()
            val email = binding.email.editText!!.text.toString()
            val mobile = binding.mobile.editText!!.text.toString()
            val alt_mobile = binding.alternative.editText!!.text.toString()
           // binding.Gender.setText("Gender: "+"${textgender}")
            val gender = when {
                binding.male.isChecked -> "Male"
                binding.female.isChecked -> "Female"
                binding.tsgender.isChecked -> "Transgender"
                else -> ""
            }


            if (mobile != alt_mobile) {

                val intent=Intent(this, SecondMainActivity::class.java)
                intent.putExtra("fName", fname)
                intent.putExtra("lName", lName)
                intent.putExtra("email", email)
                intent.putExtra("mobile", mobile)
                intent.putExtra("alt_mobile", alt_mobile)
                intent.putExtra("gender", gender)

                val hobbies=StringBuilder()
                if (binding.program.isChecked) {
                    hobbies.append("Programming\n")
                }

                if (binding.nobel.isChecked) {
                    hobbies.append("Study Nobel\n")
                }

                if (binding.movie.isChecked) {
                    hobbies.append("Watching Movie\n")
                }

                if (binding.game.isChecked) {
                    hobbies.append("Gaming\n")
                }

                if (binding.travell.isChecked) {
                    hobbies.append("Travelling\n")
                }

                // Add the selected hobbies as an extra to the intent
                intent.putExtra("hobbies", hobbies.toString())
                intent.putExtra("checkbox", Hobbies)


                startActivity(intent)
            }
            else
            {
                binding.alternative.error = "Alternative number cannot be the same as mobile number"
            }
        }


        // initialize view binding

        // get references to views
        val fname=binding.FirstName.editText!!.text.toString()
        val lname=binding.LastName.editText!!.text.toString()
        val mobile=binding.mobile.editText!!.text.toString()
        val alter=binding.alternative.editText!!.text.toString()
        val email=binding.email.editText!!.text.toString()
        binding.radioGroup.setOnCheckedChangeListener(this)
        binding.program.setOnCheckedChangeListener(this)
        binding.movie.setOnCheckedChangeListener(this)
        binding.game.setOnCheckedChangeListener(this)
        binding.nobel.setOnCheckedChangeListener(this)
        binding.travell.setOnCheckedChangeListener(this)
        // set onClickListener for submit button



//        binding.btnSubmit.setOnClickListener {
////            // get input values
//
//
//            binding.FullName.setText("Your name : " + binding.FirstName.editText!!.text.toString() + " " + binding.LastName.editText!!.text.toString())
//            binding.Mobile.setText("phone number : +91" + binding.mobile.editText!!.text.toString())
//            binding.Alter.setText("Alternative ph.no. : +91" + binding.alternative.editText!!.text.toString())
//            binding.Email.setText("E-mail Address: " + binding.email.editText!!.text.toString())
//            binding.Gender.setText("Gender: "+"${textgender}")
//            binding.checkbox.setText("Hobbies: "+"${Hobbies}")
//
//
//        }


    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item:MenuItem): Boolean {
        when (item.itemId){
            R.id.item_01 -> Toast.makeText(this,"About Selected",Toast.LENGTH_SHORT).show()
            R.id.item_02 -> Toast.makeText(this,"Settings Selected",Toast.LENGTH_SHORT).show()
            R.id.item_03-> Toast.makeText(this,"Exit Selected",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun isValidEmail(email:String):Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidMobile(mobile:String):Boolean {
        return Patterns.PHONE.matcher(mobile).matches()

    }

    override fun onCheckedChanged(radio:RadioGroup?, p1:Int) {
        when(radio?.checkedRadioButtonId) {
            R.id.male->
            {
                val rbmale=findViewById<RadioButton>(p1)
                textgender=rbmale.text.toString()
            }
            R.id.female->
            {
                val rbfemale=findViewById<RadioButton>(p1)
                textgender=rbfemale.text.toString()
            }
            R.id.tsgender->
            {
                val rbtsgender=findViewById<RadioButton>(p1)
                textgender=rbtsgender.text.toString()
            }
        }


    }

    override fun onCheckedChanged(p0:CompoundButton?, p1:Boolean) {
        when(p0?.id){
            R.id.program->
            {
                if(binding.program.isChecked)
                {
                    Hobbies.add(binding.program.text.toString())
                }
                else
                {
                    Hobbies.remove(binding.program.text.toString())
                }
            }

            R.id.game->
            {
                if(binding.game.isChecked)
                {
                    Hobbies.add(binding.game.text.toString())
                }
                else
                {
                    Hobbies.remove(binding.game.text.toString())
                }
            }

            R.id.movie->
            {
                if(binding.movie.isChecked)
                {
                    Hobbies.add(binding.movie.text.toString())
                }
                else
                {
                    Hobbies.remove(binding.movie.text.toString())
                }
            }

            R.id.travell->
            {
                if(binding.travell.isChecked)
                {
                    Hobbies.add(binding.travell.text.toString())
                }
                else
                {
                    Hobbies.remove(binding.travell.text.toString())
                }
            }

            R.id.nobel->
            {
                if(binding.nobel.isChecked)
                {
                    Hobbies.add(binding.nobel.text.toString())
                }
                else
                {
                    Hobbies.remove(binding.nobel.text.toString())
                }
            }
        }
    }
}

