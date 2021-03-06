/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.jvm.dynamictype;

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
* @Package：cn.ucaner.jvm.dynamictype   
* @ClassName：GrandFatherCaller   
* @Description：   <p> 
* 
* 使用 MethodHandle 来访问祖类方法
* 为什么打印出来的是 "i am father" 而不是 "i am grandfather"?
* 参考:
* https://www.zhihu.com/question/57379777
* https://www.zhihu.com/question/40427344/answer/86545388
* </p>
* @Author： -    
* @CreatTime：2018年5月22日 上午9:27:17   
* @Modify By：   
* @ModifyTime：  2018年5月22日
* @Modify marker：   
* @version    V1.0
 */
public class GrandFatherCaller {
    class GrandFather {
        void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = lookup().findSpecial(
                        GrandFather.class, "thinking", mt, Son.class);
                mh.invoke(this);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        (new GrandFatherCaller().new Son()).thinking();
    }
}
