package io.kimmking.rpcfx.api;

import lombok.Data;

@Data
public class RpcfxRequest<T> {
  private T serviceClass;
  private String method;
  private Object[] params;
}
