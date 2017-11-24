package jy16.androidmusic;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    private  static final String TAG = "MusicServices";
    public MediaPlayer mediaPlayer;
    public MyService() {
    }

    class MyBinder extends Binder{
        public void play(String path){
            try{
                //如果播放器为空，创建播放器并播放音频
                if(mediaPlayer==null){

                    //创建播放器
                    mediaPlayer=new MediaPlayer();
                    //指定音频文件
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    //指定音频路径
                    mediaPlayer.setDataSource(path);
                    //准备播放
                    mediaPlayer.prepare();
                    //播放监听
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
                        //准备播放对象
                        public void onPrepared(MediaPlayer mp){
                            //开始播放方法
                            mediaPlayer.start();
                        }
                    });
                }else {
                    //否则获取当前音频位置进行播放
                    int posiotion=getCurrentProgress();
                    //从指定位置播放
                    mediaPlayer.seekTo(posiotion);
                    try{
                        mediaPlayer.prepare();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    mediaPlayer.start();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        public void pause(){
            if(mediaPlayer!=null&&mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }else if(mediaPlayer!=null&&(!mediaPlayer.isPlaying())){
                mediaPlayer.start();
            }
        }
    }

    public int getCurrentProgress(){
        if (mediaPlayer!=null&mediaPlayer.isPlaying()){
            return mediaPlayer.getCurrentPosition();
        }else if(mediaPlayer!=null&(!mediaPlayer.isPlaying())){
            return mediaPlayer.getCurrentPosition();
        }
        return  0;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        super.onDestroy();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
}
