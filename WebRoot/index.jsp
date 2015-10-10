<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<title>我的私人博客(项目起始于2015.10.03)</title>
<meta name="description" content="这个网站是一个用于我自己发表博客的 -- by Primarywind" />

<!-- 针对手持设备优化，主要是针对一些老的不识别viewport的浏览器，比如黑莓 -->
<meta name="HandheldFriendly" content="True" />

<!--viewport 可以让布局在移动浏览器上显示的更好-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--网址列前面出现的Icon-->
<link rel="shortcut icon" href="/Myweb/assets/images/favicon.ico">

<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/highlight.js/8.5/styles/monokai_sublime.min.css">
<link rel="stylesheet" type="text/css"
	href="/Myweb/assets/css/screen.css" />

<link rel="alternate" type="application/rss+xml" title="我的私人博客"
	href="http://blog.csdn.net/primary_wind" />
</head>
<body class="home-template">

	<!-- start header -->
	<header class="main-header"
		style="background-image:url('/Myweb/assets/images/index.jpg');">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">

					<h1>
						<span class="hide">Laravel - </span>为自己搭建的小窝 -- Primarywind
					</h1>

					<h2 class="hide">PHP THAT DOESN'T HURT. CODE HAPPY &amp; ENJOY
						THE FRESH AIR.</h2>

					<img
						src="http://image.golaravel.com/e/b0/4e4bd788405aab87f03d26edc4ab4.png"
						alt="Laravel" class="hide">
				</div>

				<div class="col-sm-12">
					<a href="http://struts.apache.org/" class="btn btn-default btn-doc"
						target="_blank">struts</a> <a
						href="http://projects.spring.io/spring-framework/"
						class="btn btn-default btn-doc" target="_blank">spring</a> <a
						href="http://hibernate.org/" class="btn btn-default btn-doc"
						target="_blank">hibernate</a> <a href="http://www.java.com/zh_CN/"
						class="btn btn-default btn-doc" target="_blank">java</a> <a
						href="http://developer.51cto.com/art/201001/176550.htm"
						class="btn btn-default btn-doc" target="_blank">jvm</a> <a
						href="http://wenda.golaravel.com" class="btn btn-default btn-doc"
						target="_blank">交流屋</a>
				</div>
			</div>
		</div>
	</header>
	<!-- end header -->

	<!-- start navigation -->
	<nav class="main-navigation">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="navbar-header">
						<span class="nav-toggle-button collapsed" data-toggle="collapse"
							data-target="#main-menu"> <span class="sr-only">Toggle
								navigation</span> <i class="fa fa-bars"></i> </span>
					</div>
					<div class="collapse navbar-collapse" id="main-menu">
						<ul class="menu">
							<li class="nav-current"><a href="/">首页</a>
							</li>
							<li><a href="/" target="_blank">技术相关</a></li>
							<li><a href="/" target="_blank">生活相关</a></li>
							<li><a href="/" target="_blank">资源文档</a></li>
							<li><a href="/" target="_blank">照片画廊</a></li>
							<li><a href="/" target="_blank">交流屋</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<!-- end navigation -->


	<!-- start site's main content area -->
	<section class="content-wrap">
		<div class="container">
			<div class="row">

				<main class="col-md-8 main-content">
				<div id="main-content"></div>
				<nav class="pagination" role="navigation">
					<a class="older-posts" href="#" id="previous"><i
						class="fa fa-angle-left"></i> </a> <span class="page-number"
						id="page-number"></span> <a class="older-posts" href="#" id="next"><i
						class="fa fa-angle-right"></i> </a>
				</nav>
				</main>

				<aside class="col-md-4 sidebar">
					<!-- start widget -->
					<!-- end widget -->

					<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">联系方式</h4>

						<div class="content community">
							<p>QQ：4905564</p>

							<p>
								<a href="http://blog.csdn.net/primary_wind" title="csdn博客"
									target="_blank"
									onclick="_hmt.push(['_trackEvent', 'big-button', 'click', 'csdn博客'])"><i
									class="fa fa-comments"></i> csdn博客连接</a>
							</p>
						</div>
					</div>
					<!-- end tag cloud widget -->

					<!-- start tag cloud widget -->
					<div class="widget">
						<h4 class="title">标签云</h4>

						<div class="content tag-cloud">
							<a href="/tag/laravel/">Laravel</a> <a href="/tag/laravel-5/">Laravel
								5</a> <a href="/tag/getting-started-with-laravel/">Laravel入门教程</a> <a
								href="/tag/eloquent/">Eloquent</a> <a href="/tag/laravel-5-1/">Laravel
								5.1</a> <a href="/tag/laravle5/">laravle5</a> <a
								href="/tag/xin-ban-ben-fa-bu/">新版本发布</a> <a href="/tag/orm/">ORM</a>
							<a href="/tag/composer/">Composer</a> <a href="/tag/lts/">LTS</a>
							<a href="/tag/artisan/">Artisan</a> <a href="/tag/php/">PHP</a> <a
								href="/tag/spark/">Spark</a> <a href="/tag/jing-xiang/">镜像</a> <a
								href="/tag/wei-kuang-jia/">微框架</a> <a href="/tag/lumen/">Lumen</a>
							<a href="/tag/ming-ming-kong-jian/">命名空间</a> <a
								href="/tag/laravel4/">Laravel4</a> <a href="/tag-cloud/">...</a>
						</div>
					</div>
					<!-- end tag cloud widget -->

				</aside>

			</div>
		</div>
	</section>

	<footer class="main-footer">
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">最新文章</h4>

						<div class="content recent-post"></div>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">标签云</h4>

						<div class="content tag-cloud">
							<a href="/tag/laravel/">Laravel</a> <a href="/tag/laravel-5/">Laravel
								5</a> <a href="/tag/getting-started-with-laravel/">Laravel入门教程</a> <a
								href="/tag/eloquent/">Eloquent</a> <a href="/tag/laravel-5-1/">Laravel
								5.1</a> <a href="/tag/laravle5/">laravle5</a> <a
								href="/tag/xin-ban-ben-fa-bu/">新版本发布</a> <a href="/tag/orm/">ORM</a>
							<a href="/tag/composer/">Composer</a> <a href="/tag/lts/">LTS</a>
							<a href="/tag/artisan/">Artisan</a> <a href="/tag/php/">PHP</a> <a
								href="/tag/spark/">Spark</a> <a href="/tag/jing-xiang/">镜像</a> <a
								href="/tag/wei-kuang-jia/">微框架</a> <a href="/tag-cloud/">...</a>
						</div>
					</div>
				</div>

				<div class="col-sm-4">
					<div class="widget">
						<h4 class="title">合作伙伴</h4>

						<div class="content tag-cloud friend-links">
							<a href="http://www.bootcss.com" title="Bootstrap中文网"
								onclick="_hmt.push(['_trackEvent', 'link', 'click', 'bootcsscom'])"
								target="_blank">Bootstrap中文网</a> <a href="http://www.bootcdn.cn"
								title="开放CDN服务"
								onclick="_hmt.push(['_trackEvent', 'link', 'click', 'bootcdncn'])"
								target="_blank">开放CDN服务</a> <a href="http://www.gruntjs.net"
								title="Grunt中文网"
								onclick="_hmt.push(['_trackEvent', 'link', 'click', 'gruntjsnet'])"
								target="_blank">Grunt中文网</a>
							<hr>
							<a href="https://www.upyun.com/" title="又拍云"
								onclick="_hmt.push(['_trackEvent', 'link', 'click', 'upyun'])"
								target="_blank">又拍云</a> <a href="http://www.ucloud.cn/"
								title="UCloud"
								onclick="_hmt.push(['_trackEvent', 'link', 'click', 'ucloud'])"
								target="_blank">UCloud</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<div class="copyright">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<span>Copyright &copy; <a href="#"> 中文网</a> </span> | <span><a
						href="/" target="_blank">京ICP备1111号</a> </span> | <span>京公网安备1111</span>
				</div>
			</div>
		</div>
	</div>

	<a href="#" id="back-to-top"><i class="fa fa-angle-up"></i> </a>

	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script
		src="http://cdn.bootcss.com/fitvids/1.1.0/jquery.fitvids.min.js"></script>
	<script src="http://cdn.bootcss.com/highlight.js/8.5/highlight.min.js"></script>

	<script type="text/template" id="brief">  
				<article id={articleId} class="post tag-laravel-5-1 tag-xin-ban-ben-fa-bu">
					<div class="post-head">
						<h1 class="post-title">
							<a href="">{title}</a>
						</h1>

						<div class="post-meta">
							<span class="author">作者：<a href="/author/wangsai/">{userName}</a>
							</span> &bull;
							<time class="post-date" datetime=""
								title="">{pubTime} </time>
						</div>
					</div>
					<div class="post-content">
						<p>{briefIndc}</p>
					</div>
					<div class="post-permalink">
						<a href="javascript:void(0)" class="btn btn-default" onClick="goToDetail('{articleId}')">阅读全文</a>
					</div>

					<footer class="post-footer clearfix">
						<div class="pull-left tag-list">
							<i class="fa fa-folder-open-o"></i> <a href="/tag/laravel-5-1/">{label}</a>
						</div>
						<div class="pull-right share"></div>
					</footer>
				</article>
                
    </script>
	<script type="text/template" id="detail">  
	<article id="{articleId}" class="post tag-spark"> 
    <header
		class="post-head">
	<h1 class="post-title">{title}</h1>
	<section class="post-meta"> <span class="author">作者：<a
		href="/author/wangsai/">{userName}</a>
	</span> • <time class="post-date">{pubTime}</time> </section> </header> <section
		class="post-content"> {content} </section> <footer
		class="post-footer clearfix">
	<div class="pull-left tag-list">
		<i class="fa fa-folder-open-o"></i> <a href="/tag/spark/">{label}</a>
	</div>
	</footer> 
    </article>
	<div class="about-author clearfix">
		<a href="/author/wangsai/"><img
			src="http://image.golaravel.com/6/d4/82b9646073bef7a7d67c6cd1db987.png"
			alt="{userName}" class="avatar pull-left">
		</a>

		<div class="details">
			<div class="author">
				关于作者 <a href="/author/wangsai/">{userName}</a>
			</div>
			<div class="meta-info">
				<span class="loaction"><i class="fa fa-home"></i>湖北</span> <span
					class="website"><i class="fa fa-globe"></i><a
					href="http://www.bootcss.com/" targer="_blank">个人网站/博客</a>
				</span>
			</div>
		</div>
	</div>
     </script>

	<script src="/Myweb/assets/js/main.js"></script>
</body>
</html>