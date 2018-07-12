package com.jew.ActivitiDeveloperQuickStart.jvm;

public class Test1 {

	public static void main(String[] args) {
		// 查看GC信息
		System.out.println("max memory=" + Runtime.getRuntime().maxMemory());
		System.out.println("free memory=" + Runtime.getRuntime().freeMemory());
		System.out.println("total memory=" + Runtime.getRuntime().totalMemory());

		byte[] b1 = new byte[1 * 1024 * 1024];
		System.out.println("分配了1M");
		// 查看GC信息
		System.out.println("max memory=" + Runtime.getRuntime().maxMemory());
		System.out.println("free memory=" + Runtime.getRuntime().freeMemory());
		System.out.println("total memory=" + Runtime.getRuntime().totalMemory());
		byte[] b2 = new byte[10 * 1024 * 1024];
		System.out.println("分配了10M");
		// 查看GC信息
		System.out.println("max memory=" + Runtime.getRuntime().maxMemory());
		System.out.println("free memory=" + Runtime.getRuntime().freeMemory());
		System.out.println("total memory=" + Runtime.getRuntime().totalMemory());
		System.out.println((0x00000000ff2a0000-0x00000000fec00000)/1024);
	}
}
