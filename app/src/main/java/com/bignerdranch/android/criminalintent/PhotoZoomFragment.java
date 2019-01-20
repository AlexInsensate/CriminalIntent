package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import java.io.File;
import java.util.Date;
import java.util.GregorianCalendar;


public class PhotoZoomFragment extends DialogFragment implements View.OnClickListener {
    private static final String ARG_PATH = "path";

    private ImageView mPhotoZoom;

    public static PhotoZoomFragment newInstance(String path) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PATH, path);
        PhotoZoomFragment fragment = new PhotoZoomFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_photo, null);
        mPhotoZoom = v.findViewById(R.id.photo_zoom);
        final String path = (String) getArguments().getSerializable(ARG_PATH);
        Bitmap bitmap = PictureUtils.getScaledBitmap(path, getActivity());
        mPhotoZoom.setImageBitmap(bitmap);
        return new AlertDialog.Builder(getActivity()).
                setView(v).create();
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
