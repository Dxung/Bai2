package com.example.bai2

class StudentDatabase {
    private val dataList : MutableList<StudentDataStructure> = mutableListOf()

    init {
        dataList.add((StudentDataStructure("Le Tran Phu","20233535")))
        dataList.add((StudentDataStructure("Pham Thi Hanh","20242519")))
        dataList.add((StudentDataStructure("Nguyen Van Cuong","20233348")))
        dataList.add((StudentDataStructure("Pham Dang Vu Duc","20243761")))
        dataList.add((StudentDataStructure("Dang Ngoc Cuong","20222654")))
        dataList.add((StudentDataStructure("Le Thi Yen","20193401")))
        dataList.add((StudentDataStructure("Nguyen Hoang Tung","20203939")))
        dataList.add((StudentDataStructure("Nguyen Tran Trung Quan","20223254")))
        dataList.add((StudentDataStructure("Ngo Minh Dang","20212411")))
        dataList.add((StudentDataStructure("Le Minh Pham","20232700")))
        dataList.add((StudentDataStructure("Dinh Phu Sang","20242192")))
        dataList.add((StudentDataStructure("Pham Tran Phu","20212456")))
        dataList.add((StudentDataStructure("Le Quang Minh","20203460")))
        dataList.add((StudentDataStructure("Hoang Phu Thai Y","20212189")))
        dataList.add((StudentDataStructure("Ngo Bui Cuong","20203384")))
        dataList.add((StudentDataStructure("Hoang Minh Hanh","20233912")))
        dataList.add((StudentDataStructure("Phu Tran","20202956")))

    }

    fun getList(): MutableList<StudentDataStructure>{
        return dataList
    }



}