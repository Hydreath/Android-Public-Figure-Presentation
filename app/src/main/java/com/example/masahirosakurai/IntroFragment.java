package com.example.masahirosakurai;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {
    ImageView c1;
    ImageView c2;
    ImageView c3;
    ImageView c4;
    ImageView head;
    boolean canInteract = true;

    public IntroFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View finalView = inflater.inflate(R.layout.fragment_intro, container, false);
        c1 = (ImageView) finalView.findViewById(R.id.c1);
        c2 = (ImageView) finalView.findViewById(R.id.c2);
        c3 = (ImageView) finalView.findViewById(R.id.c3);
        c4 = (ImageView) finalView.findViewById(R.id.c4);
        head = (ImageView) finalView.findViewById(R.id.headshot);

        //Ação a executar quando tocar no circulo central
        head.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(canInteract){
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            AnimatorSet set = new AnimatorSet();
                            set.addListener(new AnimatorListenerAdapter() {
                                @Override
                                //Impedir que a animação seja executada novamente
                                public void onAnimationStart(Animator animation) {
                                    canInteract = false;
                                    super.onAnimationStart(animation);
                                }
                                //Alterar o fragmento no final da animação
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    MainActivity m = (MainActivity) getActivity();
                                    m.changeFragment(new DescricaoFragment(), View.VISIBLE);

                                }
                            });

                            //Animação a executar após tocar no ciculo central
                            ObjectAnimator a1 = ObjectAnimator.ofPropertyValuesHolder(v,
                                    PropertyValuesHolder.ofFloat("scaleX", 0f),
                                    PropertyValuesHolder.ofFloat("scaleY", 0f));
                            a1.setDuration(100);

                            ObjectAnimator a2 = ObjectAnimator.ofPropertyValuesHolder(c4,
                                    PropertyValuesHolder.ofFloat("scaleX", 0f, 1000f),
                                    PropertyValuesHolder.ofFloat("scaleY", 0f, 1000f));
                            a2.setStartDelay(200);
                            a2.setDuration(400);

                            set.playTogether(a1, a2);
                            set.start();
                            break;
                    }
                }
                return false;
            }
        });

        //Animação constante dos circulos
        ObjectAnimator scaleDown1 = ObjectAnimator.ofPropertyValuesHolder(
                c1,
                PropertyValuesHolder.ofFloat("scaleX", 1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        scaleDown1.setDuration(1100);
        scaleDown1.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown1.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown1.start();
        //Circle 2 animation
        ObjectAnimator scaleDown2 = ObjectAnimator.ofPropertyValuesHolder(
                c2,
                PropertyValuesHolder.ofFloat("scaleX", 1.2f),
                PropertyValuesHolder.ofFloat("scaleY", 1.2f));
        scaleDown2.setDuration(910);
        scaleDown2.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown2.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown2.start();
        //Circle3 animation
        ObjectAnimator scaleDown3 = ObjectAnimator.ofPropertyValuesHolder(
                c3,
                PropertyValuesHolder.ofFloat("scaleX", 1.5f),
                PropertyValuesHolder.ofFloat("scaleY", 1.5f));
        scaleDown3.setDuration(1100);
        scaleDown3.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown3.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown3.start();
        Toast t = Toast.makeText(getContext(), "Toque no centro", Toast.LENGTH_LONG);
        t.setGravity(Gravity.BOTTOM, 0, 200);
        t.show();
        return finalView;
    }

}
