package com.heisenberg.blbl.test.concurrent;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.infra.results.II_Result;

/**
 * 要用jdk17运行
 * volatile 可以禁止指令重排序
 * 写操作加的屏障是阻止上方其他写操作越过屏障排到volatile变量写之下，
 * 读操作加的屏障是阻止下方其他读操作越过屏障排到volatile变量读之上
 * @author Heisenberg
 * @version 1.0
 * @date 2024-07-03 20:29:29
 */

@JCStressTest
@Outcome(id = {"0, 0", "1, 1", "0, 1"}, expect = Expect.ACCEPTABLE, desc = "ACCEPTABLE")
@Outcome(id = "0, 1", expect = Expect.ACCEPTABLE, desc = "INTERESTING")
public class JcstressTest {
    int x;
    volatile int y;

    @Actor
    public void actorA(){
        x = 1;
        y = 1;
    }

    @Actor
    public void actorB(II_Result r){
        r.r1 = y;
        r.r2 = x;
    }
}
