package com.spa.stargate.stargatespa;

import com.blade.Blade;

public class DemoApplication {

	public static void main(String[] args) {
		Blade.of().get("/", ctx -> ctx.text("Hello Blade")).start();
	}

}
