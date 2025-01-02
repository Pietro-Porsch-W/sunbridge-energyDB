import { Avatar, AvatarFallback, AvatarImage } from './ui/avatar';
import ItensMenu from './ItensMenu';
import SubmenuComponent from './Submenu';
import { useRef, useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

interface MenuProps {
    usuarioID: string;
}

function Menu({ usuarioID }: MenuProps) {
    const [hoveredIndex, setHoveredIndex] = useState<number | null>(null);
    const [openSubmenu, setOpenSubmenu] = useState<string | null>(null);
    const [nome, setNome] = useState<string | null>(null);
    const [isMouseInSubmenu, setIsMouseInSubmenu] = useState<boolean>(false);
    const buttonRefs = useRef<(HTMLDivElement | null)[]>([]);
    const submenuRef = useRef<HTMLDivElement | null>(null);
    const { usuarioID: usuarioIDFromURL } = useParams<{ usuarioID: string }>();
    
    const usuarioAtual = usuarioID || usuarioIDFromURL;

    useEffect(() => {
        const fetchNome = async () => {
            if (usuarioAtual) {
                try {
                    const response = await fetch(`http://localhost:8080/usuario/find/id/${usuarioAtual}`);
                    const data = await response.json();
                    if (response.ok && data.nome) {
                        setNome(data.nome);
                    } else {
                        console.error('Erro ao obter o nome do usuário');
                    }
                } catch (error) {
                    console.error('Erro na requisição:', error);
                }
            }
        };

        fetchNome();
    }, [usuarioAtual]);

    const updatedItensMenu = Object.entries(ItensMenu).reduce((acc, [key, submenu]) => {
        acc[key] = {
            ...submenu,
            options: submenu.options.map(option => {
                const isAbsolute = option.link.startsWith('http');
                const adjustedLink = isAbsolute
                    ? option.link
                    : `/${usuarioAtual}/${option.link}`.replace(/\/+/g, '/');
                return { ...option, link: adjustedLink };
            }),
        };
        return acc;
    }, {} as Record<string, typeof ItensMenu[keyof typeof ItensMenu]>);

    const handleMouseEnter = (item: keyof typeof ItensMenu, index: number) => {
        setHoveredIndex(index);
        setOpenSubmenu(item);
    };

    const handleMouseLeaveMenu = (event: React.MouseEvent) => {
        if (
            !submenuRef.current?.contains(event.relatedTarget as Node) &&
            !buttonRefs.current.some(ref => ref?.contains(event.relatedTarget as Node)) &&
            !isMouseInSubmenu
        ) {
            setHoveredIndex(null);
            setOpenSubmenu(null);
        }
    };

    const handleMouseEnterSubmenu = () => {
        setIsMouseInSubmenu(true);
    };

    const handleMouseLeaveSubmenu = () => {
        setIsMouseInSubmenu(false);
    };

    const handleCloseSubmenu = () => {
        setOpenSubmenu(null);
    };

    // Adiciona um event listener para cliques fora do submenu
    useEffect(() => {
        const handleClickOutside = (event: MouseEvent) => {
            if (
                submenuRef.current && !submenuRef.current.contains(event.target as Node) &&
                buttonRefs.current.every(ref => ref && !ref.contains(event.target as Node))
            ) {
                setOpenSubmenu(null); // Fecha o submenu
            }
        };

        document.addEventListener('click', handleClickOutside);

        return () => {
            document.removeEventListener('click', handleClickOutside);
        };
    }, []);

    return (
        <div className="flex flex-col w-[10vw]">
            <div className="flex flex-col w-full max-w-sm md:max-w-md lg:max-w-lg mx-auto bg-[#0064F3] text-white">
                <div className="flex flex-col justify-center items-center gap-1">
                    <span className="text-2xl">Sunbridge</span>
                    <Avatar className="flex rounded-full">
                        <AvatarImage src="https://github.com/shadcn.png" className="rounded-full" />
                        <AvatarFallback></AvatarFallback>
                    </Avatar>
                    <span className="text-center p-2">{nome ? nome : usuarioAtual}</span>
                </div>
            </div>
            <div className="flex bg-blue-500 w-full h-full max-w-sm md:max-w-md lg:max-w-lg mx-auto flex-col gap-2 relative">
                <div className="pt-7">
                    {Object.keys(updatedItensMenu).map((item, index) => (
                        <div
                            key={index}
                            ref={(el) => { buttonRefs.current[index] = el; }}
                            className={`flex items-center justify-center hover:underline cursor-pointer p-2 transition-colors duration-300 ${hoveredIndex === index ? 'text-white' : 'text-gray-200'}`}
                            onMouseEnter={() => handleMouseEnter(item as keyof typeof ItensMenu, index)}
                            onMouseLeave={handleMouseLeaveMenu}
                            role="button"
                            aria-haspopup="true"
                            aria-expanded={openSubmenu === item ? 'true' : 'false'}
                        >
                            {updatedItensMenu[item].title}
                        </div>
                    ))}
                </div>
                {openSubmenu && (
                    <div
                        ref={submenuRef}
                        className="absolute left-full top-0 z-[100]"
                        onMouseEnter={handleMouseEnterSubmenu}
                        onMouseLeave={handleMouseLeaveSubmenu}
                    >
                        <SubmenuComponent
                            menu={updatedItensMenu[openSubmenu]}
                            onClose={handleCloseSubmenu}
                            onMouseEnter={() => {}}
                            onMouseLeave={() => {}}
                        />
                    </div>
                )}
            </div>
        </div>
    );
}

export default Menu;
