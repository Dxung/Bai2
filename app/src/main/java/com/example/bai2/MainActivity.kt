package com.example.bai2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bai2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding : ActivityMainBinding
    private lateinit var dataBase : StudentDatabase
    private lateinit var customAdapter : CustomAdapter
    private var searchResultList: MutableList<StudentDataStructure> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initProperty()
        setContentView(mainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun initProperty(){
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        initDatabase()
        initCustomAdapter()
        addButtonListener()


    }

    private fun initDatabase(){
        dataBase = StudentDatabase()
    }

    private fun initCustomAdapter(){
        customAdapter = CustomAdapter(this,searchResultList)
        mainBinding.listView.adapter = customAdapter
    }

    private fun addButtonListener(){
        mainBinding.searchButton.setOnClickListener{
            UpdateResult()
            customAdapter.notifyDataSetChanged()
        }
    }

    private fun UpdateResult(){
        searchResultList.clear()

        val infoYouKnow = mainBinding.searchPlace.text.toString() //text của TextView ở đây trả về CharSequence
        var infoYouKnowNormalize = infoYouKnow.trim().replace(" ","") //trim : bo khoạng trong dau va cuoi



        if(infoYouKnowNormalize.length <= 2){
            searchResultList.addAll(dataBase.getList()) /**** KHÔNG DÙNG = DATABASE.GETLIST() Ở ĐÂY VÌ: VIỆC THAY ĐÓ CHỈ CHUYỂN THAM CHIẾU CỦA BIẾN SEARCHRESULTLIST ĐẾN VÙNG NHỚ CỦA DATABSE.GETLIST(), NHƯNG ADAPTOR VẪN ĐANG LÀM VIỆC VỚI VÙNG NHỚ CŨ => KHÔNG NHẬN ĐƯỢC CẬP NHẬT  ***/
                                                        /*** KẾT LUẬN: ADAPTOR LÀM VIỆC VỚI VÙNG NHỚ CHỨ KHÔNG PHẢI VỚI BIẾN ***/

            Log.d("check",searchResultList.size.toString())

        }else{

            ifExistInDatabase(infoYouKnowNormalize)
            if(searchResultList.isEmpty()){
                mainBinding.notificationText.text = getString(R.string.no_result_found)
            }
        }

    }

    private fun ifExistInDatabase(inputNormalized: String){

        for (value: StudentDataStructure in dataBase.getList()){
            var studentNameNormalize = value.studentName.trim().replace(" ","")
            var studentIDNormalize = value.studentId.trim().replace(" ","")



            if(studentNameNormalize.contains(inputNormalized,ignoreCase = true) || studentIDNormalize.contains(inputNormalized,ignoreCase = true)){
                mainBinding.notificationText.text = getString(R.string.result_found)
                searchResultList.add(value)
            }

        }
    }

}