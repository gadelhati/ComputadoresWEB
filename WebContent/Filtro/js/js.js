function minhaFuncaoA() {
	var x = document.getElementById("demo");
	x.style.fontSize = "25px";
	x.style.color = "red";
}
function minhaFuncaoB() {
	document.getElementById("demo").innerHTML = "Conteúdo Diferente.";
}
function trocarImagem() {
    var imagem = document.getElementById('minhaImagem');
    if (image.src.match("bulbon")) {
        image.src = "imagens/git.png";
    } else {
        image.src = "imagens/github.png";
    }
}