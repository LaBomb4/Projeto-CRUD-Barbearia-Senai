var menuItem = document.querySelectorAll('.item-menu');
const telefoneMask = document.querySelector('#telefone');

function selectLink(){
    menuItem.forEach((item)=>
        item.classList.remove('ativo')
    )
    this.classList.add('ativo')
}

menuItem.forEach((item)=>
    item.addEventListener('click', selectLink)
)

var btnExp = document.querySelector('#btn-exp')
var menuSide = document.querySelector('.menu-lateral')

btnExp.addEventListener('click', function(){
    menuSide.classList.toggle('expandir')
})

// Captura o formulário de agendamento
const formAgendamento = document.querySelector('form');

if (formAgendamento) {
    formAgendamento.addEventListener('submit', function() {
        const btn = this.querySelector('button[type="submit"]');
        
        // Desativa o botão para evitar múltiplos envios
        btn.disabled = true;
        
        // Muda o texto para dar um feedback visual
        btn.innerHTML = '<span class="spinner-border spinner-border-sm"></span> Agendando...';
    });
}

// mascara para o telefone
telefoneMask.addEventListener('input', function() {
    this.value = this.value
        .replace(/\D/g, '')
        .replace(/(\d{2})(\d)/, '($1) $2')
        .replace(/(\d{4,5})(\d)/, '$1-$2')
        .replace(/(-\d{4})\d+?$/, '$1');
});