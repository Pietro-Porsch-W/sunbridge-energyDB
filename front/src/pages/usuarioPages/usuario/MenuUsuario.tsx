import Usuarios from "./ItemUsuarioApi";

function MenuUsuario() {
    return (
        <div className="relative flex flex-col w-full justify-center text-xl bg-[#EEEEEE]">
            <div className="flex justify-center items-center bg-[#0064F3] w-full h-[7vh] gap-4 text-white text-sm absolute top-0">
                <div className="flex-1 text-center">Nome</div>
                <div className="flex-1 text-center">Email</div>
                <div className="flex-1 text-center">Telefone</div>
                <div className="flex-1 text-center">Cidade</div>
                <div className="flex-1 text-center">Data de Registro</div>
            </div>
            <Usuarios />
        </div>
    );
}

export default MenuUsuario;
