 package com.example.mapeojson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONObject

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var response = "{ \"personas\" : [ " +
                "{" +
                " \"nombre\" : \"Marcos\" ," +
                " \"pais\" : \"México\" ," +
                " \"estado\" : \"soltero\" ," +
                " \"experiencia\" : 5}," +

                "{" +
                " \"nombre\" : \"Agustín\" ," +
                " \"pais\" : \"España\" ," +
                " \"estado\" : \"casado\" ," +
                " \"experiencia\" : 16}" +
                " ]" +
                " }"

        val json = JSONObject(response)
        val people = json.getJSONArray("personas")

        for(i in 0..people.length() - 1){
            val name = people.getJSONObject(i).getString("nombre")
            val country = people.getJSONObject(i).getString("pais")
            val state = people.getJSONObject(i).getString("estado")
            val experience = people.getJSONObject(i).getInt("experiencia")

            val person = Person(name, country, state, experience)

            Log.d("PERSON", person.name)
        }

    }
}