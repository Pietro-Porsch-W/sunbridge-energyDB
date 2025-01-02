import SearchLoja from "@/components/SearchLoja";
import ItensEditEmpresa from "./ItensEdit";
import MenuEmpresa from "./MenuEmpresa";
import Menu from "@/components/Menu";
import { useParams } from "react-router-dom";

function Empresa() {
    const { usernameID } = useParams<{ usernameID: string }>();

    return (
        <div className="flex">
           <Menu usuarioID={usernameID || "Problema ao encontrar"}/>
            <div className="flex flex-col w-full">
                <SearchLoja/>
                <div className="flex h-[92.2vh] bg-[#F5F5F5] justify-center items-center">
                    <div className="flex w-[75%] h-[100%] justify-center items-center">
                        <div className="flex w-full h-full">
                            <div className="flex flex-col w-full bg-[#EEEEEE] mt-[2.2%] mb-[10vh]">
                                <ItensEditEmpresa usernameID={usernameID || ""} />
                                <div className="flex flex-col w-full items-center justify-center overflow-y-auto bg-[#EEEEEE] text-center">
                                    <MenuEmpresa />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Empresa;
