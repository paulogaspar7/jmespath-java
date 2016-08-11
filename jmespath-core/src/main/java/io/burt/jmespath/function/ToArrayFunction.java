package io.burt.jmespath.function;

import java.util.List;
import java.util.Arrays;

import io.burt.jmespath.Adapter;
import io.burt.jmespath.JmesPathType;

public class ToArrayFunction extends BaseFunction {
  public ToArrayFunction() {
    super(ArgumentConstraints.anyValue());
  }

  @Override
  protected <T> T callFunction(Adapter<T> runtime, List<ExpressionOrValue<T>> arguments) {
    T subject = arguments.get(0).value();
    if (runtime.typeOf(subject) == JmesPathType.ARRAY) {
      return subject;
    } else {
      return runtime.createArray(Arrays.asList(subject));
    }
  }
}
