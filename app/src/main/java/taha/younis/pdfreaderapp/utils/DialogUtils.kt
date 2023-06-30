package com.orbitalsonic.pdfloader.utils


import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.Window
import androidx.databinding.DataBindingUtil
import com.orbitalsonic.pdfloader.interfaces.OnDialogPermissionClickListener
import taha.younis.pdfreaderapp.R
import taha.younis.pdfreaderapp.databinding.DialogPermissionBinding

object DialogUtils {

    fun permissionDialog(
        context: Context,
        listener: OnDialogPermissionClickListener
    ) {
        val mDialog = Dialog(context)
        val dialogBinding: DialogPermissionBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context), R.layout.dialog_permission, null, false
        )
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mDialog.setContentView(dialogBinding.root)
        mDialog.setCanceledOnTouchOutside(false)

        val mListener = listener

        dialogBinding.btnCancel.setOnClickListener {
            mDialog.dismiss()
        }

        dialogBinding.btnProceed.setOnClickListener {
            mDialog.dismiss()
            mListener.onProceedClick()
        }

        mDialog.show()

    }

}