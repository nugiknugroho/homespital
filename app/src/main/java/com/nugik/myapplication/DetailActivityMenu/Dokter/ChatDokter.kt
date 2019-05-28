package com.nugik.myapplication.DetailActivityMenu.Dokter

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.nugik.myapplication.API.ApiEndPoint
import com.nugik.myapplication.RVAAdapter.AdapterChat
import com.nugik.myapplication.Data.Chat
import com.nugik.myapplication.LogRegister.MainActivity
import kotlinx.android.synthetic.main.activity_chat_dokter.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import com.nugik.myapplication.R
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONObject

class ChatDokter : AppCompatActivity() {

    private lateinit var listViewType: MutableList<Int>
    private lateinit var listChat: MutableList<Chat>
    private lateinit var adapterChat: AdapterChat
    lateinit var ia:Intent

    private val requestCodeGallery = 1
    private val requestCodeCamera = 2
    private val requestCodePermission = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_dokter)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        checkRuntimePermissions()
        edit_text_chat_activity_main.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                sendTextMessage()
            }
            true
        }
        button_send_message_activity_main.setOnClickListener {
            sendTextMessage()
        }
        button_send_image_activity_main.setOnClickListener {
            sendImageMessage()
        }
        setupAdapterRecyclerView()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            (android.R.id.home)->{
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun checkRuntimePermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA), requestCodePermission)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        grantResults.forEach {
            if (it == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "This permissions is needed for full functional app", Toast.LENGTH_SHORT)
                        .show()
                finish()
            }
        }
    }

    private fun sendImageMessage() {
        val idTypeChat = radio_group_activity_main.checkedRadioButtonId
        val typeChat = if (idTypeChat == R.id.radio_button_my_self_activity_main) {
            AdapterChat.VIEW_TYPE_MY_SELF
        } else {
            AdapterChat.VIEW_TYPE_USER
        }
        val builderAlertDialog = AlertDialog.Builder(this)
                .setTitle("Pilih Aksi")
                .setItems(arrayOf("Gallery", "Kamera")) { dialogInterface, indexItem ->
                    dialogInterface.dismiss()
                    when (indexItem) {
                        0 -> {
                            val intentImagePicker = Intent(Intent.ACTION_PICK)
                            intentImagePicker.type = "image/*"
                            startActivityForResult(intentImagePicker, requestCodeGallery)
                        }
                        1 -> {
                            val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                            startActivityForResult(intentCamera, requestCodeCamera)
                        }
                    }
                }
        val alertDialog = builderAlertDialog.create()
        alertDialog.show()
    }

    private fun sendTextMessage() {
        ia = intent
        val idTypeChat = radio_group_activity_main.checkedRadioButtonId

        val typeChat = if (idTypeChat == R.id.radio_button_my_self_activity_main) {
            AdapterChat.VIEW_TYPE_MY_SELF
        } else {
            AdapterChat.VIEW_TYPE_USER
        }
        val message = edit_text_chat_activity_main.text.toString().trim()
        if (message.isEmpty()) {
            Toast.makeText(this@ChatDokter, "Message is empty", Toast.LENGTH_SHORT)
                    .show()
        } else {
            val dateTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
                    .format(Date())
            val chat = Chat(message = message, dateTime = dateTime, image = "")
            var cg=ia.getStringExtra("id_dokter")
            AndroidNetworking.post(ApiEndPoint.PESAN)
                    .addBodyParameter("id_dokter", "1")
                    .addBodyParameter("isi",message)
                    .addBodyParameter("waktu",dateTime)
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(object : JSONObjectRequestListener {

                        override fun onResponse(response: JSONObject?) {

                            Toast.makeText(applicationContext,response?.getString("message"), Toast.LENGTH_SHORT).show()

                            if(response?.getString("message")?.contains("successfully")!!){
                                listViewType.add(typeChat)
                                listChat.add(chat)
                                adapterChat.notifyDataSetChanged()
                            }

                        }

                        override fun onError(anError: ANError?) {
                            Log.d("ONERROR",anError?.errorDetail?.toString())
                            Toast.makeText(applicationContext,"Koneksi Gagal", Toast.LENGTH_SHORT).show()                    }


                    })

        }
    }

    private fun setupAdapterRecyclerView() {
        listViewType = mutableListOf()
        listChat = mutableListOf()
        adapterChat = AdapterChat(listViewType = listViewType, listChat = listChat)
        recycler_view_chat_activity_main.layoutManager = LinearLayoutManager(this)
        recycler_view_chat_activity_main.adapter = adapterChat
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                requestCodeGallery -> {
                    val fileImage = getBitmapFile(data)
                    if (fileImage != null) {
                        val idTypeChat = radio_group_activity_main.checkedRadioButtonId
                        val typeChat = if (idTypeChat == R.id.radio_button_my_self_activity_main) {
                            AdapterChat.VIEW_TYPE_MY_SELF
                        } else {
                            AdapterChat.VIEW_TYPE_USER
                        }
                        val message = ""
                        val dateTime = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.US)
                                .format(Date())
                        val chat = Chat(message = message, dateTime = dateTime, image = fileImage.absolutePath)
                        listViewType.add(typeChat)
                        listChat.add(chat)
                        adapterChat.notifyDataSetChanged()
                    }
                }
                requestCodeCamera -> {
                    val thumbnail = data?.extras!!["data"] as Bitmap
                    val baos = ByteArrayOutputStream()
                    thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, baos)
                    val dir = File("${Environment.getExternalStorageDirectory()}/ChatLayout")
                    if (!dir.exists()) {
                        dir.mkdirs()
                    }

                    try {
                        val fileImage = File(dir, "${Calendar.getInstance().timeInMillis}.jpg")
                        fileImage.createNewFile()
                        val fileOutputStream = FileOutputStream(fileImage)
                        fileOutputStream.write(baos.toByteArray())

                        MediaScannerConnection.scanFile(this, arrayOf(fileImage.path), arrayOf("image/jpeg"), null)
                        fileOutputStream.close()

                        val idTypeChat = radio_group_activity_main.checkedRadioButtonId
                        val typeChat = if (idTypeChat == R.id.radio_button_my_self_activity_main) {
                            AdapterChat.VIEW_TYPE_MY_SELF
                        } else {
                            AdapterChat.VIEW_TYPE_USER
                        }
                        val message = ""
                        val dateTime = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.US)
                                .format(Date())
                        val chat = Chat(message = message, dateTime = dateTime, image = fileImage.absolutePath)
                        listViewType.add(typeChat)
                        listChat.add(chat)
                        adapterChat.notifyDataSetChanged()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    private fun getBitmapFile(data: Intent?): File? {
        data?.let {
            val selectedImage = it.data
            val cursor = contentResolver
                    .query(selectedImage, arrayOf(MediaStore.Images.ImageColumns.DATA), null, null, null)
            cursor.moveToFirst()

            val index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            val selectedImagePath = cursor.getString(index)
            cursor.close()
            return File(selectedImagePath)
        }
        return null
    }
}
