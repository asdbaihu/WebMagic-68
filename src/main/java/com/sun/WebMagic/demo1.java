package com.sun.WebMagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class demo1 implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

	public void process(Page page) {
		us.codecraft.webmagic.selector.Html html = page.getHtml();
		
		System.out.println(html.get());
	}

	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		Spider.create(new demo1()).addUrl("http://apps.webofknowledge.com").thread(5).run();
	}
}