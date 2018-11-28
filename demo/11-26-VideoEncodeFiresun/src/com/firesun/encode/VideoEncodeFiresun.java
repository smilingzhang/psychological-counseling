package com.firesun.encode;

public class VideoEncodeFiresun {
    public static int getEncode(int pre) {
		int aft = (pre+pre)*pre;
    	return aft;
    }
    public static int setEncode(int aft) {
    	int pre = (int) Math.sqrt(aft/2);
    	return pre;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int pre = 10;
        int after = VideoEncodeFiresun.getEncode(pre);
        System.out.println(after);
        int pre2 = VideoEncodeFiresun.setEncode(after);
        System.out.println(pre2);
	}

}
