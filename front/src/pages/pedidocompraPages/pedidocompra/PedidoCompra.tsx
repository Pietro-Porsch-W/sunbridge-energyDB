import Menu from "@/components/Menu";
import SearchLoja from "@/components/SearchLoja";
import ItensEdit from "./ItensEdit";
import { useParams } from "react-router-dom";
import MenuPedidoCompra from "./MenuPedidoCompra";

function PedidoCompras() {
  const { usernameID } = useParams<{ usernameID: string }>();
  return (
    <div className="flex min-h-screen bg-gray-100 z-50">
      <Menu usuarioID={usernameID || ""}/>
      <div className="flex flex-col w-full">
        <SearchLoja />
        <div className="flex h-[92.2vh] bg-gray-100 justify-center items-center">
          <div className="flex w-[75%] h-[100%] justify-center items-center">
            <div className="flex w-full h-full">
              <div className="flex flex-col w-full h-[100%] bg-white shadow-lg rounded-lg mt-5 mb-10">
                {/* ItensEdit Section */}
                <ItensEdit usernameID={usernameID || ""} />
  

                {/* MenuCliente Section */}
                <div className="flex flex-col w-full items-center justify-center text-center rounded-b-lg">
                  <MenuPedidoCompra />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default PedidoCompras;
