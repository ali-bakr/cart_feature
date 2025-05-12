package com.aliaboubakr.core_ui.ui.utils

import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.aliaboubakr.core_ui.R

object DialogUtils {

    fun showGeneralMessageDialog(
        context: Context,
        message: String,
        positiveText: String = "OK",
        negativeText: String? = null,
        onPositive: (() -> Unit)? = null,
        onNegative: (() -> Unit)? = null
    ) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.general_dialog_message, null)
        val messageTextView = dialogView.findViewById<TextView>(R.id.messageTextView)
        val positiveButton = dialogView.findViewById<Button>(R.id.positiveButton)
        val negativeButton = dialogView.findViewById<Button>(R.id.negativeButton)

        messageTextView.text = message
        positiveButton.text = positiveText
        negativeButton.text = negativeText ?: "Cancel"

        val dialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .setCancelable(false)
            .create()

        positiveButton.setOnClickListener {
            onPositive?.invoke()
            dialog.dismiss()
        }

        negativeButton.setOnClickListener {
            onNegative?.invoke()
            dialog.dismiss()
        }

        dialog.show()
    }
}
