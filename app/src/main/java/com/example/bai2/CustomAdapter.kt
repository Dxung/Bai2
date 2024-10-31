package com.example.bai2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.bai2.databinding.StudentListviewItemBinding

class CustomAdapter(private val context:Context, private val students: List<StudentDataStructure>) :BaseAdapter() {
    override fun getCount(): Int {
        return students.size
    }

    override fun getItem(position: Int): Any {
        return students[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val itemBinding: StudentListviewItemBinding = if (convertView == null) {
                // Nếu convertView là null, tạo mới View Binding
                StudentListviewItemBinding.inflate(LayoutInflater.from(context), parent, false)
            } else {
                // Nếu convertView không null, tái sử dụng binding
                StudentListviewItemBinding.bind(convertView)
            }

            itemBinding.studentName.text = students[position].studentName
            itemBinding.studentId.text = students[position].studentId

            return itemBinding.root
        }
}