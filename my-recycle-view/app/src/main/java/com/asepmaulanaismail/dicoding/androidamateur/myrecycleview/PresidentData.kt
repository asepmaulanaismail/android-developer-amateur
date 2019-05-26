package com.asepmaulanaismail.dicoding.androidamateur.myrecycleview

object PresidentData {
    var data = arrayOf(
        arrayOf(
            "Soekarno",
            "Presiden Pertama RI",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Presiden_Sukarno.jpg/418px-Presiden_Sukarno.jpg"
        ),
        arrayOf(
            "Soeharto",
            "Presiden Kedua RI",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/President_Suharto%2C_1993.jpg/468px-President_Suharto%2C_1993.jpg"
        ),
        arrayOf(
            "Bacharuddin Jusuf Habibie",
            "Presiden Ketiga RI",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Bacharuddin_Jusuf_Habibie_official_portrait.jpg/520px-Bacharuddin_Jusuf_Habibie_official_portrait.jpg"
        ),
        arrayOf(
            "Abdurrahman Wahid",
            "Presiden Keempat RI",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/President_Abdurrahman_Wahid_-_Indonesia.jpg/486px-President_Abdurrahman_Wahid_-_Indonesia.jpg"
        ),
        arrayOf(
            "Megawati Soekarnoputri",
            "Presiden Kelima RI",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/President_Megawati_Sukarnoputri_-_Indonesia.jpg/540px-President_Megawati_Sukarnoputri_-_Indonesia.jpg"
        ),
        arrayOf(
            "Susilo Bambang Yudhoyono",
            "Presiden Keenam RI",
            "https://upload.wikimedia.org/wikipedia/commons/5/58/Presiden_Susilo_Bambang_Yudhoyono.png"
        ),
        arrayOf(
            "Joko Widodo",
            "Presiden Ketujuh RI",
            "https://upload.wikimedia.org/wikipedia/commons/1/1c/Joko_Widodo_2014_official_portrait.jpg"
        )
    )

    val listData: ArrayList<President>
        get() {
            var president: President?
            val list = arrayListOf<President>()
            for (aData in data) {
                president = President()
                president.name = aData[0]
                president.remarks = aData[1]
                president.photo = aData[2]

                list.add(president)
            }

            return list
        }
}