package taha.younis.pdfreaderapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import taha.younis.pdfreaderapp.databinding.ActivityPdfBinding
import java.io.File

class PdfActivity : AppCompatActivity() {

    var filePath = ""
    private lateinit var binding: ActivityPdfBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_pdf )

        filePath = intent.getStringExtra("path").toString()

        val file = File(filePath)
        val path = Uri.fromFile(file)
        binding.pdfView.fromUri(path).load()

    }
}