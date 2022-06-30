var mySwiper = new Swiper('.swiper', {
	autoplay: {
		delay: 3000,
		stopOnLastSlide: false,
		disableOnInteraction: true,
	},
	navigation: {
		nextEl: '.swiper-button-next',
		prevEl: '.swiper-button-prev'
	},
	pagination: {
		el: '.swiper-pagination',
		type: 'bullets',
		clickable: true
	}
});
