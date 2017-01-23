package com.resturant.me;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CustomAdapter extends PagerAdapter{

	Context context;
	String one;
    
     
    public CustomAdapter(Context context,String one){
        this.context = context;
         this.one=one;
    }
     
     
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
         
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
         
        View viewItem = inflater.inflate(R.layout.allrest, container, false);
        ImageView imageview = (ImageView) viewItem.findViewById(R.id.imageView);
        switch(one)
		{
		case "kin":
			imageview.setImageResource(kin[position]);
			break;
		case "bn":
			imageview.setImageResource(bn[position]);
			break;
		case "sabr":
			imageview.setImageResource(sabr[position]);
			break;
		case "wel":
			imageview.setImageResource(wel[position]);
			break;
		case "mo":
			imageview.setImageResource(mo[position]);
			break;
		case "mh":
			imageview.setImageResource(mh[position]);
			break;
		case "bake":
			imageview.setImageResource(bake[position]);
			break;
		case "x":
			imageview.setImageResource(x[position]);
			break;
		case "ft":
			imageview.setImageResource(ft[position]);
			break;
		case "s3":
			imageview.setImageResource(s3[position]);
			break;
		case "rsh":
			imageview.setImageResource(rsh[position]);
			break;
		case "kh":
			imageview.setImageResource(kh[position]);
			break;
		case "hd":
			imageview.setImageResource(hd[position]);
			break;
		case "st":
			imageview.setImageResource(st[position]);
			break;
		case "am":
			imageview.setImageResource(am[position]);
			break;
		case "ban":
			imageview.setImageResource(ban[position]);
			break;
		case "ayoub":
			imageview.setImageResource(ayoub[position]);
			break;
		case "kat":
			imageview.setImageResource(kat[position]);
			break;
		case "robin":
			imageview.setImageResource(robin[position]);
			break;
		case "nine":
			imageview.setImageResource(nine[position]);
			break;
		case "zen":
			imageview.setImageResource(zen[position]);
			break;
		case "sph":
			imageview.setImageResource(sph[position]);
			break;
		case "ageba":
			imageview.setImageResource(ageba[position]);
			break;
		case "kok":
			imageview.setImageResource(kok[position]);
			break;
		case "wal":
			imageview.setImageResource(wal[position]);
			break;
			case "pot":
				imageview.setImageResource(pot[position]);
				break;
		}
        ((ViewPager)container).addView(viewItem);
         
        return viewItem;
    }
 
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
    	int s=0;
    	switch(one)
		{
		case "kin":
			s= kin.length;
			break;
		case "bn":
			s= bn.length;
			break;
		case "wel":
			s= wel.length;
			break;
		case "mo":
			s= mo.length;
			break;
		case "mh":
			s= mh.length;
			break;
			
		case "bake":
			s= bake.length;
			break;
		case "x":
			s= x.length;
			break;
		case "ft":
			s= ft.length;
			break;
		case "s3":
			s= ft.length;
			break;
		case "rsh":
			s= rsh.length;
			break;
		case "kh":
			s= kh.length;
			break;
			case "pot":
				s= pot.length;
				break;
		case "hd":
			s= hd.length;
			break;
		case "ban":
			s= ban.length;
			break;
		case "st":
			s= st.length;
			break;
		case "am":
			s= am.length;
			break;
		case "ayoub":
			s= ayoub.length;
			break;
		case "sabr":
			s= sabr.length;
			break;
		case "nine":
			s= nine.length;
			break;
		case "robin":
			s= robin.length;
			break;
		case "zen":
			s= zen.length;
			break;
		case "sph":
			s= sph.length;
			break;
		case "ageba":
			s= ageba.length;
			break;
		case "kok":
			s= kok.length;
			break;
		case "wal":
			s= wal.length;
			break;
		}
    	return s;
    }
 
    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub
         
        return view == ((View)object);
    }
 
 
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }
    
    
    public static Integer[] kin=
		{
    	R.drawable.kin1,
		R.drawable.kin2,
		R.drawable.kin3,
		
		};
    public static Integer[] pot=
            {
                    R.drawable.pot,

            };
    public static Integer[] bn=
		{
    	R.drawable.n2,
		R.drawable.n3,
		R.drawable.n4,
		
		};
    public static Integer[] bake=
		{
    	R.drawable.ba1,
    	R.drawable.ba2,
		};
    public static Integer[] rsh=
		{
    	R.drawable.rsh1,
    	R.drawable.rsh2,
		};
    public static Integer[] s3=
		{
    	R.drawable.s3,
		};
    public static Integer[] kh=
		{
    	R.drawable.kh,
		
		};
    public static Integer[] hd=
		{
    	R.drawable.hd,
		
		};
    public static Integer[] wel=
		{
    	R.drawable.wel1,
		R.drawable.wel2,
		R.drawable.wel3,
        R.drawable.wel4,
		};
	public static Integer[] x=
		{
		R.drawable.e1,
		R.drawable.e2,
		R.drawable.e3,
		R.drawable.e4,
		R.drawable.e5,
		};
		
	public static Integer[] mh=
		{
		
		};
	public static Integer[] ft=
		{
		R.drawable.fto1,
		R.drawable.fto2,
		};
	public static Integer[] sabr=
		{
		R.drawable.sabr1,
		R.drawable.sabr2,
		};
	public static Integer[] mo=
		{
		R.drawable.mo,
		
		};
	public static Integer[] nine=
		{
		R.drawable.nine1,
		R.drawable.nine2,
		R.drawable.nine3,
		R.drawable.nine4,
		R.drawable.nine5,
		R.drawable.nine6,
		R.drawable.nine7,
		};
	public static Integer[] st=
		{

		R.drawable.st1,
		R.drawable.st2,
		};
	public static Integer[] am=
		{

		R.drawable.am1,
		R.drawable.am2,
		};
	public static Integer[] ban=
		{
		R.drawable.ban1,
		R.drawable.ban2,
		R.drawable.ban3,
		};
	public static Integer[] ayoub=
		{

		R.drawable.a1,
		R.drawable.a2,
        R.drawable.a3,
		};
	public static Integer[] kat=
		{
		R.drawable.k1,
		R.drawable.k2,
		};
	public static Integer[] robin=
		{
		R.drawable.ro1,
		};
	public static Integer[] zen=
		{
		R.drawable.z1,
		R.drawable.z2,
		R.drawable.z3,
		};
	public static Integer[] sph=
		{
		R.drawable.sph1,
		R.drawable.sph2,
		};
	public static Integer[] ageba=
		{
		R.drawable.ag1,
		R.drawable.ag2,
		};
	public static Integer[] kok=
		{
		R.drawable.kok1,
		R.drawable.kok2,
		R.drawable.kok3,
		};
	public static Integer[] wal=
		{
		R.drawable.wal1,
		R.drawable.wal2,
		R.drawable.wal3,
		};

	
}