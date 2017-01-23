package com.resturant.me;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;


public class AllPat extends Activity implements OnClickListener{

	String whichOne;
	String telephone;
	ImageButton call,menuBar,Three;
	ImageView v;
	int move=0;


    int length;
    private final String appKey="kid_Syyxg5dB";
    private final String appSecret="0a7e69ebd0654fe8835459fc3e482fe5";
    SharedPreferences sharedPref;


    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.allrest);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);

        menuBar = (ImageButton) findViewById(R.id.menuMenu);
        Three = (ImageButton) findViewById(R.id.threeMenu);

		whichOne=getIntent().getStringExtra("pat");
		telephone=getIntent().getStringExtra("num");
		this.setTitle("");
		call = (ImageButton) findViewById(R.id.call);
		TouchImageView img = new TouchImageView(this);
		switch(whichOne)
		{
		case "s3":
	//		AdBuddiz.setPublisherKey("3bbc3558-c5c9-4a70-a2a4-bc9d411df6cc");
	//		AdBuddiz.cacheAds(this);
	//		AdBuddiz.showAd(this);
		    img.setImageResource(CustomAdapter.s3[move]);
		    break;
		case "sabr":
	//		AdBuddiz.setPublisherKey("3bbc3558-c5c9-4a70-a2a4-bc9d411df6cc");
	//		AdBuddiz.cacheAds(this);
	//		AdBuddiz.showAd(this);
		    img.setImageResource(CustomAdapter.sabr[move]);
		    break;
		
			
		}
		call.setOnClickListener(this);
        menuBar.setOnClickListener(this);
        Three.setOnClickListener(this);
		img.setMaxZoom(4f);
		LinearLayout my = (LinearLayout) findViewById(R.id.imageView);
		LinearLayout A = new LinearLayout(this);

		A.addView(img);
		my.addView(A);

        int count = getCount("V"+whichOne);
        createSharedPreferences("V" + whichOne, count + 1);

        if(isConnected(getApplicationContext())){
            Toast.makeText(getApplicationContext(), String.valueOf("PATE"), Toast.LENGTH_LONG).show();
            SendData sendData = new SendData(sharedPref , getApplicationContext());
            sendData.execute(whichOne);
        }


    }

    public  boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null ;

    }


    private int getCount(String Restaurant_Name) {
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        int no = sharedPref.getInt(Restaurant_Name, 0);
        //Toast.makeText(getApplicationContext(),String.valueOf(no),Toast.LENGTH_SHORT).show();
        return no;
    }

    private void createSharedPreferences(String Restaurant_Name , int no) {
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(Restaurant_Name, no);
        editor.commit();
    }

    public static int getImageId(Context context, String imageName) {
	    return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.call:
            int count = getCount("C"+whichOne);
            createSharedPreferences("C"+whichOne,count+1);

            SendData sendData = new SendData(sharedPref , getApplicationContext());
            sendData.execute(whichOne);

            Intent phoneIntent = new Intent(Intent.ACTION_CALL);
		      phoneIntent.setData(Uri.parse(telephone));

		      try {
		         startActivity(phoneIntent);
		      } catch (android.content.ActivityNotFoundException ex) {
		         
		      }
			break;

            case R.id.menuMenu:
                View mm=findViewById(R.id.menuMenu);
                PopupMenu popm=new PopupMenu(AllPat.this,mm);
                popm.getMenuInflater().inflate(R.menu.menubar, popm.getMenu());
                popm.show();
                popm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // TODO Auto-generated method stub
                        switch(item.getItemId())
                        {
                            case R.id.menurest:
                                Intent i = new Intent(AllPat.this,Rest.class);
                                startActivity(i);
                                break;
                            case R.id.menupat:
                                Intent i1 = new Intent(AllPat.this,Pat.class);
                                startActivity(i1);
                                break;

                            case R.id.menucafe:
                                Intent i11 = new Intent(AllPat.this,Cafes.class);
                                startActivity(i11);
                                break;
                            case R.id.menuice:
                                Intent i12 = new Intent(AllPat.this,Ice.class);
                                startActivity(i12);
                                break;

                        }
                        return false;
                    }
                });
                break;
            case R.id.threeMenu:
                View mn=findViewById(R.id.threeMenu);
                PopupMenu popm1=new PopupMenu(AllPat.this,mn);
                popm1.getMenuInflater().inflate(R.menu.settingsbar, popm1.getMenu());
                popm1.show();
                popm1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // TODO Auto-generated method stub
                        switch(item.getItemId())
                        {
                            case R.id.menurate:
                                String url = "https://play.google.com/store/apps/details?id=com.resturant.me";
                                Intent i1 = new Intent(Intent.ACTION_VIEW);
                                i1.setData(Uri.parse(url));
                                startActivity(i1);
                                break;
                            case R.id.menucreates:
                                Intent i = new Intent(AllPat.this,Names.class);
                                startActivity(i);
                                break;
                            case R.id.menucontact:
                                String url1 = "https://www.facebook.com/3rfnyKFS";
                                Intent i11 = new Intent(Intent.ACTION_VIEW);
                                i11.setData(Uri.parse(url1));
                                startActivity(i11);
                                break;

                        }
                        return false;
                    }
                });
                break;

		}
		
	}
	
	private void Imagenow(int move2,String who) {
		// TODO Auto-generated method stub
		TouchImageView img = new TouchImageView(this);
		LinearLayout my = (LinearLayout) findViewById(R.id.imageView);
		LinearLayout A1 = new LinearLayout(AllPat.this);
		my.removeAllViews();
		A1.removeAllViews();
		A1.addView(img);
		my.addView(A1);
		if(move2<=0)
			{
		move2=0;
            }
		switch(who)
		{
		
		case "s3":
		if(move2>=CustomAdapter.s3.length-1)
            move2=CustomAdapter.s3.length-1;
		    img.setImageResource(CustomAdapter.s3[move2]);
		    my.removeAllViews();
			   A1.removeAllViews();
			   A1.addView(img);
				my.addView(A1);
		    break;
		
		case "sabr":
			if(move2>=CustomAdapter.sabr.length-1)
                move2=CustomAdapter.sabr.length-1;
		   img.setImageResource(CustomAdapter.sabr[move2]);
		   my.removeAllViews();
		   A1.removeAllViews();
		   A1.addView(img);
			my.addView(A1);
		    break;
		}
		img.setMaxZoom(4f);
		
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
	//	MenuInflater mm=getMenuInflater();
	//	mm.inflate(R.menu.bar,menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{

		
		}
		
		
		return true;
	}
    public class TouchImageView extends ImageView {
        Matrix matrix;
        // We can be in one of these 3 states
        static final int NONE = 0;
        static final int DRAG = 1;
        static final int ZOOM = 2;

        int mode = NONE;

        // Remember some things for zooming
        PointF last = new PointF();
        PointF start = new PointF();
        float minScale = 1f;
        float maxScale = 3f;
        float[] m;
        int viewWidth, viewHeight;

        static final int CLICK = 3;

        float saveScale = 1f;

        protected float origWidth, origHeight;

        int oldMeasuredWidth, oldMeasuredHeight;

        ScaleGestureDetector mScaleDetector;

        Context context;

        public TouchImageView(Context context) {
            super(context);
            sharedConstructing(context);
        }

        public TouchImageView(Context context, AttributeSet attrs) {
            super(context, attrs);
            sharedConstructing(context);
        }

        private void sharedConstructing(Context context) {

            super.setClickable(true);

            this.context = context;

            mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());

            matrix = new Matrix();

            m = new float[9];

            setImageMatrix(matrix);

            setScaleType(ScaleType.MATRIX);

            setOnTouchListener(new OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    mScaleDetector.onTouchEvent(event);

                    PointF curr = new PointF(event.getX(), event.getY());

                    switch (event.getAction()) {

                        case MotionEvent.ACTION_DOWN:

                            last.set(curr);

                            start.set(last);

                            mode = DRAG;

                            break;

                        case MotionEvent.ACTION_MOVE:

                            if (mode == DRAG) {

                                float deltaX = curr.x - last.x;

                                float deltaY = curr.y - last.y;

                                float fixTransX = getFixDragTrans(deltaX, viewWidth, origWidth * saveScale);

                                float fixTransY = getFixDragTrans(deltaY, viewHeight, origHeight * saveScale);

                                matrix.postTranslate(fixTransX, fixTransY);

                                fixTrans();



                                last.set(curr.x, curr.y);


                            }

                            break;

                        case MotionEvent.ACTION_UP:

                            mode = NONE;

                            int xDiff = (int) Math.abs(curr.x - start.x);

                            int yDiff = (int) Math.abs(curr.y - start.y);
                            nextMove(curr.x,start.x, viewWidth, origWidth * saveScale);

                            if (xDiff < CLICK && yDiff < CLICK)

                                performClick();

                            break;

                        case MotionEvent.ACTION_POINTER_UP:

                            mode = NONE;

                            break;

                    }

                    setImageMatrix(matrix);

                    invalidate();

                    return true; // indicate event was handled

                }

            });
        }
        private void nextMove(float x_new, float x_old,float width,float now) {


            if((x_new -x_old) >=50 && width >= now && move>=1 )
            {
                move=move-1;
                Toast.makeText(getApplicationContext(), (move + 1) + " / " + (length + 1), Toast.LENGTH_SHORT).show();
                Imagenow(move, whichOne);
            }
            if( (x_old - x_new) >=50 && width >= now && move < length)
            {
                move=move+1;
                Toast.makeText(getApplicationContext(), (move+1) + " / " + (length+1) , Toast.LENGTH_SHORT).show();
                Imagenow(move,whichOne);
            }
        }

        public void setMaxZoom(float x) {

            maxScale = x;

        }

        private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

            @Override
            public boolean onScaleBegin(ScaleGestureDetector detector) {

                mode = ZOOM;

                return true;

            }

            @Override
            public boolean onScale(ScaleGestureDetector detector) {

                float mScaleFactor = detector.getScaleFactor();

                float origScale = saveScale;

                saveScale *= mScaleFactor;

                if (saveScale > maxScale) {

                    saveScale = maxScale;

                    mScaleFactor = maxScale / origScale;

                } else if (saveScale < minScale) {

                    saveScale = minScale;

                    mScaleFactor = minScale / origScale;

                }

                if (origWidth * saveScale <= viewWidth || origHeight * saveScale <= viewHeight)

                    matrix.postScale(mScaleFactor, mScaleFactor, viewWidth / 2, viewHeight / 2);

                else

                    matrix.postScale(mScaleFactor, mScaleFactor, detector.getFocusX(), detector.getFocusY());

                fixTrans();

                return true;

            }

        }

        void fixTrans() {

            matrix.getValues(m);

            float transX = m[Matrix.MTRANS_X];

            float transY = m[Matrix.MTRANS_Y];

            float fixTransX = getFixTrans(transX, viewWidth, origWidth * saveScale);

            float fixTransY = getFixTrans(transY, viewHeight, origHeight * saveScale);

            if (fixTransX != 0 || fixTransY != 0)

                matrix.postTranslate(fixTransX, fixTransY);

        }



        float getFixTrans(float trans, float viewSize, float contentSize) {

            float minTrans, maxTrans;

            if (contentSize <= viewSize) {

                minTrans = 0;

                maxTrans = viewSize - contentSize;

            } else {

                minTrans = viewSize - contentSize;

                maxTrans = 0;

            }

            if (trans < minTrans)

                return -trans + minTrans;

            if (trans > maxTrans)

                return -trans + maxTrans;

            return 0;

        }

        float getFixDragTrans(float delta, float viewSize, float contentSize) {

            if (contentSize <= viewSize) {

                return 0;

            }


            return delta;

        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

            viewWidth = MeasureSpec.getSize(widthMeasureSpec);

            viewHeight = MeasureSpec.getSize(heightMeasureSpec);

            //
            // Rescales image on rotation
            //
            if (oldMeasuredHeight == viewWidth && oldMeasuredHeight == viewHeight

                    || viewWidth == 0 || viewHeight == 0)

                return;

            oldMeasuredHeight = viewHeight;

            oldMeasuredWidth = viewWidth;

            if (saveScale == 1) {

                //Fit to screen.

                float scale;

                Drawable drawable = getDrawable();

                if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0)

                    return;

                int bmWidth = drawable.getIntrinsicWidth();

                int bmHeight = drawable.getIntrinsicHeight();

                Log.d("bmSize", "bmWidth: " + bmWidth + " bmHeight : " + bmHeight);

                float scaleX = (float) viewWidth / (float) bmWidth;

                float scaleY = (float) viewHeight / (float) bmHeight;

                scale = Math.min(scaleX, scaleY);

                matrix.setScale(scale, scale);

                // Center the image

                float redundantYSpace = (float) viewHeight - (scale * (float) bmHeight);

                float redundantXSpace = (float) viewWidth - (scale * (float) bmWidth);

                redundantYSpace /= (float) 2;

                redundantXSpace /= (float) 2;

                matrix.postTranslate(redundantXSpace, redundantYSpace);

                origWidth = viewWidth - 2 * redundantXSpace;

                origHeight = viewHeight - 2 * redundantYSpace;

                setImageMatrix(matrix);

            }

            fixTrans();

        }

    }
}
