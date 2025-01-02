import { Plus } from "lucide-react";
import { Link, useParams } from "react-router-dom";

function ItensEditEmpresa() {
    const { usuarioID } = useParams<{ usuarioID: string }>(); // Captura o usuarioID da URL

    return (
        <div className="flex justify-between items-center p-4 overflow-hidden">
            <span className="text-gray-400 font-semibold pl-[4vh] text-3xl">Empresas</span>
            <div className="flex gap-3 items-center">
                <div className="flex w-[6vh] h-[6vh] bg-slate-100 rounded-full items-center justify-center text-blue-600">
                    {/* Link ajustado para incluir o usuarioID */}
                    <Link to={`/${usuarioID}/empresa/novo`}>
                        <Plus />
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default ItensEditEmpresa;
