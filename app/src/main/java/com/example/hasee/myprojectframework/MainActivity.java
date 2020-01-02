package com.example.hasee.myprojectframework;

import android.os.Looper;
import android.util.Log;

import com.example.common.base.BaseActivity;
import com.example.common.network.GetRequestInterface;
import com.example.common.network.wanandroid;
import com.example.common.utils.LogUtils;
import com.example.hasee.myprojectframework.ui.MainFragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity {
    private int fragment_container = R.id.fragment_container;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
//        switchFragmentShow(MainFragment.newInstance("","") , fragment_container);
        MainFragment fragment = MainFragment.newInstance("","");
        FragmentManager fragmentManager =  getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragment_container , fragment , fragment.getClass().getSimpleName()).show(fragment);
        transaction.commit();
    }

    @Override
    protected void requsetData() {
        LogUtils.i("MainActivity","我进来了啊啊啊啊啊");
        Log.i("MainActivity","我进来了啊啊啊啊啊2");
    }

    public void getContent() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .build();
        GetRequestInterface service = retrofit.create(GetRequestInterface.class);
//                        Call<BaseResponse<Content>> call =  service.getContent()    ;
        Call<wanandroid> call = service.getWanAndroid();
        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<wanandroid>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<wanandroid> call, Response<wanandroid> response) {
                // 步骤7：处理返回的数据结果
//                                response.body().show();
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    Log.i("myLooper", "---->我寄哪里了");
                }
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<wanandroid> call, Throwable throwable) {
                System.out.println("连接失败");
            }
        });


        Observable.just(0)
                .map(new Function<Integer, Object>() {
                    @Override
                    public Object apply(Integer integer) throws Exception {

                        return integer;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}
