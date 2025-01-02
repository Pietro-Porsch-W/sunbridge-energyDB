export interface SubmenuOption {
    name: string;
    link: string;
}

export interface Submenu {
    title: string;
    options: SubmenuOption[];
}


const ItensMenu: Record<string, Submenu> = {
    Comercial: {
        title: 'Comercial',
        options: [
            { name: 'Clientes', link: 'clientes' },
            { name: 'Pedido de Compra', link: 'pedidocompra' },
        ],
    },
    Avançado: {
        title: 'Avançado',
        options: [
            { name: 'Cadastro de Usuario', link: 'usuarios' },
            { name: 'Cadastro de Empresa', link: 'empresas' },
        ],
    },
};

export default ItensMenu;