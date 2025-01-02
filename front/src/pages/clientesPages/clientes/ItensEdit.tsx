
import { Plus } from "lucide-react";
import { Link, useParams } from "react-router-dom";

function ItensEdit() {
    const { usernameID } = useParams(); // Capturando o usernameID da rota

    return (
        <div className="flex justify-between items-center p-4 overflow-hidden">
            <span className="text-gray-400 font-semibold pl-[4vh] text-3xl ">Clientes</span>
            <div className="flex gap-3 items-center">
                <div className="flex w-[6vh] h-[6vh] bg-slate-100 rounded-full items-center justify-center text-blue-600">
                    {/* Usando usernameID na URL */}
                    <Link to={`/${usernameID}/cliente/novo`}>
                        <Plus />
                    </Link>
                </div>
            </div>
        </div>
    );
}

export default ItensEdit;
