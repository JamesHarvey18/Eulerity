function scrollAppear() {
	var petBlock = document.getElementsByClassName('pet-block')[0];
	var Position = petBlock.getBoundingClientRect().top;
	var screenPosition = window.innerHeight / 2;
	
	if (Position < screenPosition) {
		petBlock.classList.add('pet-block-appear');
	}
}

window.addEventListener('scroll', scrollAppear);