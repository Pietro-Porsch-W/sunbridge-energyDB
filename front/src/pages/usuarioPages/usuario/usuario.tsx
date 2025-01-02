import Menu from "@/components/Menu";
import SearchLoja from "@/components/SearchLoja";
import ItensEditUsuario from "./ItensEdit";
import MenuUsuario from "./MenuUsuario";
import { useParams } from "react-router-dom";

function Usuario() {
  const { usernameID } = useParams<{ usernameID: string }>();
  return (
    <div className="flex min-h-screen bg-gray-100 z-50">
       <Menu usuarioID={usernameID || "Problema ao encontrar"}/>
      <div className="flex flex-col w-full">
        <SearchLoja />
        <div className="flex h-[92.2vh] bg-gray-100 justify-center items-center">
          <div className="flex w-[75%] h-[100%] justify-center items-center">
            <div className="flex w-full h-full">
              <div className="flex flex-col w-full h-[100%] bg-white shadow-lg rounded-lg mt-5 mb-10">
                {/* ItensEdit Section */}
                <ItensEditUsuario usernameID={usernameID || ""} />   

                {/* MenuCliente Section */}
                <div className="flex flex-col w-full items-center justify-center text-center rounded-b-lg">
                  <MenuUsuario />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Usuario;
