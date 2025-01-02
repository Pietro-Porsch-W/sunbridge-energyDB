import { Plus } from "lucide-react";
import { Link } from "react-router-dom";

interface ItensEditEmpresaProps {
    usernameID: string;
}

function ItensEditEmpresa({ usernameID }: ItensEditEmpresaProps) {
    return (
        <div className="flex justify-between items-center p-4 overflow-hidden">
            <span className="text-gray-400 font-semibold pl-[4vh] text-3xl">Empresas</span>
            <div className="flex gap-3 items-center">
                <div className="flex w-[6vh] h-[6vh] bg-slate-100 rounded-full items-center justify-center text-blue-600">
                    <Link to={`/${usernameID}/empresa/novo`}>
                        <Plus />
                    </Link>
                </div>
            </div>
        </div>
    );
}

export default ItensEditEmpresa;
