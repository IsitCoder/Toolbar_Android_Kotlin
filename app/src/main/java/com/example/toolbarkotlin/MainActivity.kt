package com.example.toolbarkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.os.IResultReceiver._Parcel
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import com.example.toolbarkotlin.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Dialog Yes and NO
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add Mr Chew to contact list?")
            .setIcon(R.drawable.ic_add_contact_black)
            .setPositiveButton("Yes"){_,_->
                Toast.makeText(this,"You added Mr chew to contact list",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){_,_->
                Toast.makeText(this,"You didn't Mr chew to contact list",Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnDialog1.setOnClickListener {
            addContactDialog.show()
        }

        //choose single choice dialog

        val options = arrayOf("First item","Second item","Third item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options,0){dialogInterface,i->
                Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept"){_,_->
                Toast.makeText(this,"You accepted",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){_,_->
                Toast.makeText(this,"You decline",Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        //choose single multi dialog

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose some of these options")
            .setMultiChoiceItems(options, booleanArrayOf(true,false,false)){ _, i,isChecked->
                if(isChecked){
                Toast.makeText(this,"You checked on ${options[i]}",Toast.LENGTH_SHORT).show()
            }else {
                    Toast.makeText(this,"You unchecked on ${options[i]}",Toast.LENGTH_SHORT).show()
            }
            }
            .setPositiveButton("Accept"){_,_->
                Toast.makeText(this,"You accepted",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline"){_,_->
                Toast.makeText(this,"You decline",Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.miAddContact->Toast.makeText(this,"Add Contact",Toast.LENGTH_SHORT).show()
            R.id.miFavorites->Toast.makeText(this,"Add Favorites Item",Toast.LENGTH_SHORT).show()
            R.id.miSetting->Toast.makeText(this,"Setting",Toast.LENGTH_SHORT).show()
            R.id.miFeedback->Toast.makeText(this,"Add Feedback",Toast.LENGTH_SHORT).show()
            R.id.miClose->Toast.makeText(this,"Close",Toast.LENGTH_SHORT).show().also { finish() }
        }

        return true
    }

}





