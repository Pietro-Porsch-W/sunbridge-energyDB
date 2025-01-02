import PedidoCompra from "./ItemPedidoCompraApi";

function MenuPedidoCompra() {
    return (
        <div className="relative flex flex-col w-full h-full justify-start text-xl ">
            <div className="flex justify-center items-center bg-[#0064F3] w-full h-[7vh] min-h-[7vh] gap-4 text-white text-sm absolute top-0">
                <div className="flex-1 text-center ">Pedido de compra</div>
                <div className="flex-1 text-center ">Data do pedido</div>
                <div className="flex-1 text-center ">Empresa</div>
                <div className="flex-1 text-center ">Fornecedor</div>
                <div className="flex-1 text-center truncate">Valor</div>
            </div>
            <PedidoCompra />
        </div>
    );
}

export default MenuPedidoCompra;