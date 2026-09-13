package org.example.jmh;

import org.example.Hofstadter;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 2)
@Warmup(iterations = 2)

public class hofstadterBenchmark {
  @Param({"1", "5", "10", "15", "20", "25", "30", "35"})
  public int index;

  @Benchmark
  @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
  public void naiveBenchmark(Blackhole bh) {
      Hofstadter hofstadter = new Hofstadter();
      bh.consume(hofstadter.naivegSequence(index));
  }

  @Benchmark 
  @Timeout (time = 5, timeUnit = TimeUnit.SECONDS)
  public void memoBenchmark(Blackhole bh) {
      Hofstadter hofstadter = new Hofstadter();
      bh.consume(hofstadter.memogSequence(index));
  }
}
