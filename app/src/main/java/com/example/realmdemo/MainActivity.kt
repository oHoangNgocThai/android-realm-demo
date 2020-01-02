package com.example.realmdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        realm.executeTransaction {
            realm.deleteAll()
        }

        realm.executeTransaction { realm ->
            // Add a person

            val dog1 = Dog(1, "Fido1")
            realm.copyToRealmOrUpdate(dog1)

            val cats = arrayListOf<Cat>()
            for (j in 0 until 4) {
                val cat = Cat(j, "Cat_$j")
                cats.add(cat)
                realm.copyToRealmOrUpdate(cat)
            }

            for (i in 0..9) {
                val person = Person(i, "Person$i", i)
                if (i < 4) {
                    person.dog = dog1
                }

                if (i == 0) {
                    person.cats.add(cats[1])
                    person.cats.add(cats[2])
                }
                if (i == 6) {
                    person.cats.add(cats[0])
                    person.cats.add(cats[3])
                }

                realm.copyToRealmOrUpdate(person)
            }
        }

        bt_query.setOnClickListener {
            val cat = realm.where(Cat::class.java).equalTo("owners.name", "Person6").findAll()
            tv_result.text = "Cat first: ${cat.toString()}"
        }
    }
}
