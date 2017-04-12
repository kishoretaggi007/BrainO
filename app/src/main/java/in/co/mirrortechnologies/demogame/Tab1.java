package in.co.mirrortechnologies.demogame;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

//Our class extending fragment
public class Tab1 extends Fragment {

    //Overriden method onCreateView
    //ImageButton button;
    ImageView onelock,twolock,threelock,fourlock,fivelock,sixlock,sevenlock,eightlock,ninelock,tenlock;
    ImageView imageOne,imageTwo,imageThree,imageFour,imageFive,imageSix,imageSeven,imageEight,imageNine,imageTen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return inflater.inflate(R.layout.activity_tab1, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(onelock != null) {
            ((BitmapDrawable)onelock.getDrawable()).getBitmap().recycle();
        }
        onelock = (ImageView) view.findViewById(R.id.onelock);

        if(twolock != null) {
            ((BitmapDrawable)twolock.getDrawable()).getBitmap().recycle();
        }
        twolock = (ImageView) view.findViewById(R.id.twolock);

        if(threelock != null) {
            ((BitmapDrawable)threelock.getDrawable()).getBitmap().recycle();
        }
        threelock = (ImageView) view.findViewById(R.id.threelock);


        if(fourlock != null) {
            ((BitmapDrawable)fourlock.getDrawable()).getBitmap().recycle();
        }
        fourlock = (ImageView) view.findViewById(R.id.fourlock);

        if(fivelock != null) {
            ((BitmapDrawable)fivelock.getDrawable()).getBitmap().recycle();
        }
        fivelock = (ImageView) view.findViewById(R.id.fivelock);

        if(sixlock != null) {
            ((BitmapDrawable)sixlock.getDrawable()).getBitmap().recycle();
        }
        sixlock = (ImageView) view.findViewById(R.id.sixlock);

        if(sevenlock != null) {
            ((BitmapDrawable)sevenlock.getDrawable()).getBitmap().recycle();
        }
        sevenlock = (ImageView) view.findViewById(R.id.sevenlock);

        if(eightlock != null) {
            ((BitmapDrawable)eightlock.getDrawable()).getBitmap().recycle();
        }
        eightlock = (ImageView) view.findViewById(R.id.eightlock);

        if(ninelock != null) {
            ((BitmapDrawable)ninelock.getDrawable()).getBitmap().recycle();
        }
        ninelock = (ImageView) view.findViewById(R.id.ninelock);

        if(tenlock != null) {
            ((BitmapDrawable)tenlock.getDrawable()).getBitmap().recycle();
        }
        tenlock = (ImageView) view.findViewById(R.id.tenlock);

        imageOne = (ImageView) view.findViewById(R.id.oneImage);
        imageTwo = (ImageView) view.findViewById(R.id.twoImage);
        imageThree = (ImageView) view.findViewById(R.id.threeImage);
        imageFour = (ImageView) view.findViewById(R.id.fourimage);
        imageFive = (ImageView) view.findViewById(R.id.fiveimage);
        imageSix = (ImageView) view.findViewById(R.id.siximage);
        imageSeven = (ImageView) view.findViewById(R.id.sevenimage);
        imageEight = (ImageView) view.findViewById(R.id.eightimage);
        imageNine = (ImageView) view.findViewById(R.id.nineimage);
        imageTen = (ImageView) view.findViewById(R.id.tenimage);

        imageOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
            }
        });
        twolock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                twolock.setVisibility(View.INVISIBLE);
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
                imageTwo.setVisibility(View.VISIBLE);
            }
        });
        threelock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                threelock.setVisibility(View.INVISIBLE);
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
                imageThree.setVisibility(View.VISIBLE);
            }
        });
        fourlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                fourlock.setVisibility(View.INVISIBLE);
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
                imageFour.setVisibility(View.VISIBLE);
            }
        });
        fivelock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                fivelock.setVisibility(View.INVISIBLE);
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
                imageFive.setVisibility(View.VISIBLE);
            }
        });
        sixlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sixlock.setVisibility(View.INVISIBLE);
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
                imageSix.setVisibility(View.VISIBLE);
            }
        });
        sevenlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sevenlock.setVisibility(View.INVISIBLE);
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
                imageSeven.setVisibility(View.VISIBLE);
            }
        });
        eightlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                eightlock.setVisibility(View.INVISIBLE);
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
                imageEight.setVisibility(View.VISIBLE);
            }
        });
        ninelock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ninelock.setVisibility(View.INVISIBLE);
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
                imageNine.setVisibility(View.VISIBLE);
            }
        });
        tenlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                tenlock.setVisibility(View.INVISIBLE);
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
                imageTen.setVisibility(View.VISIBLE);
            }
        });

        imageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
            }
        });
        imageThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
            }
        });
        imageFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
            }
        });
        imageFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
            }
        });
        imageSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
            }
        });
        imageSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
            }
        });
        imageEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
            }
        });
        imageNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
            }
        });
        imageTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent icl = new Intent(getContext(), MainActivity.class);
                startActivity(icl);
            }
        });
    }
}