package com.mob.xtravuwatchdog.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mob.xtravuwatchdog.R
import com.mob.xtravuwatchdog.databinding.LoutPopupBinding
import com.mob.xtravuwatchdog.databinding.PopupLayoutSimpleBinding


class CustomDialogBuilder(private val mContext: Context?) {
    private var mBuilder: Dialog? = null

    init {
        if (mContext != null) {
            mBuilder = Dialog(mContext)
            mBuilder!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            mBuilder!!.setCancelable(false)
            mBuilder!!.setCanceledOnTouchOutside(false)

            if (mBuilder!!.window != null) {
                mBuilder!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
        }
    }
    fun getSimpleDialog(
        appCompatActivity: AppCompatActivity?,
        view: View?,
        setCancelable: Boolean
    ): Dialog {
        if (mBuilder != null && mBuilder!!.isShowing) {
            mBuilder!!.dismiss()
        }
        mBuilder = Dialog(appCompatActivity!!,android.R.style.Theme_Black_NoTitleBar_Fullscreen)





        mBuilder!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mBuilder!!.setContentView(view!!)
        val lp = WindowManager.LayoutParams()
        val window = mBuilder!!.window
        lp.copyFrom(window!!.attributes)
        mBuilder!!.setCancelable(setCancelable)
        lp.gravity = Gravity.CENTER
        lp.flags = lp.flags and WindowManager.LayoutParams.FLAG_BLUR_BEHIND.inv()
        window.attributes = lp
        mBuilder?.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);

        //  mBuilder.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //style id
        mBuilder!!.show()
        return mBuilder as Dialog
    }
    fun getSimpleDialog(
        appCompatActivity: AppCompatActivity?,
        view: View?,
        colorDrawable: ColorDrawable?,
        dialogWidth: Int,
        dialogHeight: Int,
        setCancelable: Boolean
    ): Dialog {
        if (mBuilder != null && mBuilder!!.isShowing) {
            mBuilder!!.dismiss()
        }
        mBuilder = Dialog(appCompatActivity!!)
        mBuilder!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mBuilder!!.setContentView(view!!)
        val lp = WindowManager.LayoutParams()
        val window = mBuilder!!.window
        lp.copyFrom(window!!.attributes)
        mBuilder!!.setCancelable(setCancelable)
        lp.width = dialogWidth
        lp.height = dialogHeight
        lp.gravity = Gravity.CENTER
        window.attributes = lp
        mBuilder!!.window!!.setBackgroundDrawable(colorDrawable)

        //  mBuilder.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //style id
        mBuilder!!.show()
        return mBuilder as Dialog
    }









    fun showSimpleDialog(
        title: String,
        message: String?,
        negativeText: String,
        positiveText: String?,
        onDismissListener: OnDismissListener
    ) {
        if (mContext == null) return

        mBuilder!!.setCancelable(true)
        mBuilder!!.setCanceledOnTouchOutside(false)
        val binding: LoutPopupBinding =
            DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.lout_popup, null, false)
        mBuilder!!.setContentView(binding.getRoot())
        val dialog1: Dialog1 = Dialog1()
        if (title.isEmpty()) {
            binding.title.setVisibility(View.GONE)
            binding.logoIcon.setVisibility(View.VISIBLE)
        } else if (!title.isEmpty()) {
            binding.logoIcon.setVisibility(View.VISIBLE)
            binding.title.setVisibility(View.VISIBLE)
            dialog1.title=title
        } else {
            dialog1.title=title
        }
        dialog1.message=message
        dialog1.positiveText=positiveText
        if (negativeText.isEmpty()) {
            binding.tvCancel.setVisibility(View.GONE)
            binding.line.setVisibility(View.GONE)
        } else {
            dialog1.negativeText=negativeText
        }
        binding.setModel(dialog1)
        binding.tvPositive.setOnClickListener { v ->
            mBuilder!!.dismiss()
            onDismissListener.onPositiveDismiss()
        }
        binding.tvCancel.setOnClickListener { v ->
            mBuilder!!.dismiss()
            onDismissListener.onNegativeDismiss()
        }
        mBuilder!!.show()

        //        Window window = mBuilder.getWindow();
//        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }


    fun showSimpleDialog2(
        title: String,
        message: String?,
        negativeText: String,
        positiveText: String?,
        onDismissListener: OnDismissListener
    ) {
        if (mContext == null) return

        mBuilder!!.setCancelable(true)
        mBuilder!!.setCanceledOnTouchOutside(false)
        val binding: PopupLayoutSimpleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.popup_layout_simple,
            null,
            false
        )
        mBuilder!!.setContentView(binding.getRoot())
        val dialog1: Dialog1 = Dialog1()
        if (title.isEmpty()) {
            binding.title.setVisibility(View.GONE)
        } else {
            dialog1.title=title
        }
        dialog1.message=message
        dialog1.positiveText=positiveText
        if (negativeText.isEmpty()) {
            binding.tvCancel.setVisibility(View.GONE)
            binding.line.setVisibility(View.GONE)
        } else {
            dialog1.negativeText=negativeText
        }
        binding.setModel(dialog1)
        binding.tvPositive.setOnClickListener { v ->
            mBuilder!!.dismiss()
            onDismissListener.onPositiveDismiss()
        }
        binding.tvCancel.setOnClickListener { v ->
            mBuilder!!.dismiss()
            onDismissListener.onNegativeDismiss()
        }
        mBuilder!!.show()

        //        Window window = mBuilder.getWindow();
//        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    /*
       public void showMediaDialog(OnMediaDismissListener onDismissListener) {

        if (mContext == null)
            return;

        mBuilder.setCancelable(true);
        mBuilder.setCanceledOnTouchOutside(true);
        ItemSelectMediaBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_select_media, null, false);
        mBuilder.setContentView(binding.getRoot());
        binding.tvPhoto.setOnClickListener(v -> {
            mBuilder.dismiss();
            onDismissListener.onCameraDismiss();
        });
        binding.tvVideo.setOnClickListener(v -> {
            mBuilder.dismiss();
            onDismissListener.onVideoDismiss();
        });
        binding.tvDocFile.setOnClickListener(v -> {
            mBuilder.dismiss();
            onDismissListener.onDocDismiss();
        });
        binding.tvLocation.setOnClickListener(v -> {
            mBuilder.dismiss();
            onDismissListener.onLocationDismiss();
        });
        binding.tvGiphy.setOnClickListener(v -> {
            mBuilder.dismiss();
            onDismissListener.onGifDismiss();
        });
        binding.tvCancel.setOnClickListener(v -> {
            mBuilder.dismiss();
        });
        mBuilder.show();


    }

    public void showTransferOrListNFTDialogue(OnTransferOrNftListDismissListener onTransferOrNftListDismissListener) {
        if (mContext == null)
            return;

        mBuilder.setCancelable(true);
        mBuilder.setCanceledOnTouchOutside(true);

        NftPopupDialogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.nft_popup_dialog, null, false);
        mBuilder.setContentView(binding.getRoot());
        binding.tvCancel.setOnClickListener(view -> {
            mBuilder.dismiss();
            onTransferOrNftListDismissListener.onCancelDismiss();
        });
        binding.loutNftList.setOnClickListener(view -> {
            mBuilder.dismiss();
            onTransferOrNftListDismissListener.onNftListDismiss();
        });
        binding.loutTransferNft.setOnClickListener(view -> {
            mBuilder.dismiss();
            onTransferOrNftListDismissListener.onTransferDismiss();
        });

        mBuilder.show();
//        Window window = mBuilder.getWindow();
//        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }



    public void showRequestTermDialogue(OnDismissListener onDismissListener) {
        if (mContext == null)
            return;

        mBuilder.setCancelable(true);
        mBuilder.setCanceledOnTouchOutside(true);
        DailogTermConditionBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.dailog_term_condition, null, false);
        mBuilder.setContentView(binding.getRoot());
        binding.tvTerm.setOnClickListener(v -> mContext.startActivity(new Intent(mContext, WebViewActivity.class).putExtra("type", 0)));
        binding.tvPrivacy.setOnClickListener(v -> mContext.startActivity(new Intent(mContext, WebViewActivity.class).putExtra("type", 1)));
        binding.tvPositive.setOnClickListener(v -> {
            mBuilder.dismiss();
            onDismissListener.onPositiveDismiss();
        });
        binding.tvCancel.setOnClickListener(v -> mBuilder.dismiss());
        mBuilder.show();
    }

    public void showLoadingDialog() {
        if (mContext == null)
            return;

        mBuilder.setCancelable(false);
        mBuilder.setCanceledOnTouchOutside(false);
        DailogLoaderBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.dailog_loader, null, false);
        mBuilder.setContentView(binding.getRoot());
        mBuilder.setCancelable(BuildConfig.DEBUG);
        mBuilder.show();
    }*/
    fun hideLoadingDialog() {
        try {
            mBuilder!!.dismiss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    interface OnRemoveChatDismissListener {
        fun onDeleteDismiss()

        fun onClearDismiss()

        fun onMarkDismiss(newMsg: Boolean)
    }

    fun dismiss() {
        if (mBuilder != null) {
            mBuilder!!.dismiss()
        }
    }


    interface OnDismissListener {
        fun onPositiveDismiss()

        fun onNegativeDismiss()
    }
    interface OnLoginDismissListener {
        fun onPositiveDismiss(mBuilder: Dialog)

        fun onNegativeDismiss()
    }

    interface OnMediaDismissListener {
        fun onCameraDismiss()

        fun onVideoDismiss()

        fun onDocDismiss()

        fun onLocationDismiss()

        fun onGifDismiss()
    }

    interface OnTransferOrNftListDismissListener {
        fun onCancelDismiss()

        fun onTransferDismiss()

        fun onNftListDismiss()
    }
    /*
        public void showSuccessSimpleDialog(String title, String message,String Ok, String Cancel, OnDismissListener onDismissListener) {

        if (mContext == null)
            return;

        mBuilder.setCancelable(true);
        mBuilder.setCanceledOnTouchOutside(false);
        SuccessDialogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.success_dialog, null, false);
        mBuilder.setContentView(binding.getRoot());
        Glide.with(mContext).load(R.raw.scratchanimationgif).into(binding.imgGif);
        if (title.isEmpty()) {
            binding.txtTitle.setVisibility(View.GONE);
        } else {
           binding.txtTitle.setText(title);
        }

        if (message.isEmpty()) {
            binding.txtMessage.setVisibility(View.GONE);
        } else {
            binding.txtMessage.setText(message);
        }
        if (!Ok.isEmpty()) {
            binding.txtListNow.setText(Ok);
        }

        if (Cancel.isEmpty()){
            binding.txtSkip.setVisibility(View.GONE);
        }
        else {
            binding.txtSkip.setVisibility(View.VISIBLE);
        }

        binding.txtListNow.setOnClickListener(v -> {
            mBuilder.dismiss();
            onDismissListener.onPositiveDismiss();
        });
        binding.txtSkip.setOnClickListener(v -> {
            mBuilder.dismiss();
            onDismissListener.onNegativeDismiss();
        });

       Window window = mBuilder.getWindow();
       window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
       mBuilder.show();
    }



    public void showCongratsDialog(String title,String type, OnDismissListener onDismissListener) {

        if (mContext == null)
            return;

        mBuilder.setCancelable(true);
        mBuilder.setCanceledOnTouchOutside(false);
        CongratulationLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.congratulation_layout, null, false);
        mBuilder.setContentView(binding.getRoot());
       //
        if (title.isEmpty()) {
            binding.femaleTxt.setVisibility(View.GONE);
        } else {
            binding.femaleTxt.setText(title);
        }




        binding.txtListNow.setOnClickListener(v -> {
            mBuilder.dismiss();
            onDismissListener.onPositiveDismiss();
        });


        Window window = mBuilder.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mBuilder.show();
    }


    public void appUpdateDialogDialog(int serverVersion,OnDismissListener onDismissListener) {

          try {
              PackageInfo pInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
              int versionCode = pInfo.versionCode;
              if (mContext == null)
                  return;

              System.out.println("version==" + serverVersion + "===local===" + versionCode);
              if(serverVersion!=0)
              {
                  if (serverVersion != versionCode)
                  {
                      mBuilder.setCancelable(false);
                      mBuilder.setCanceledOnTouchOutside(false);
                      UpdateappDialogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.updateapp_dialog, null, false);
                      mBuilder.setContentView(binding.getRoot());

                      binding.tvUpdate.setOnClickListener(v -> {
                          mBuilder.dismiss();
                          onDismissListener.onPositiveDismiss();
                      });
                      Window window = mBuilder.getWindow();
                      window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                      window.setGravity(Gravity.CENTER);
                      mBuilder.show();
                  }
              }

          }
          catch (Exception e){
              e.printStackTrace();
          }



    }*/
}

interface OnDismissListener {
    fun onPositiveDismiss()

    fun onNegativeDismiss()
}