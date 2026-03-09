import Image from 'next/image';

export default function About() {
  return (
    <section id="about" className="section bg-white">
      <div className="container mx-auto px-4">
        <div className="max-w-4xl mx-auto">
          <h2 className="section-title">О нашей ферме</h2>
          <p className="section-subtitle">
            Маленькая семейная ферма с большими традициями качества
          </p>

          <div className="grid md:grid-cols-2 gap-12 items-center">
            <div className="space-y-6">
              <p className="text-lg text-farm-brown leading-relaxed">
                <strong className="text-farm-green">Белая Дача</strong> — это небольшая семейная ферма,
                где мы выращиваем овощи так, как это делали наши предки: с любовью к земле и уважением к природе.
              </p>
              <p className="text-lg text-farm-brown leading-relaxed">
                Мы не используем промышленные методы выращивания. Каждый куст, каждая грядка —
                под нашим личным присмотром. Мы верим, что только так можно получить по-настоящему
                вкусные и полезные овощи.
              </p>
              <p className="text-lg text-farm-brown leading-relaxed">
                Наша земля живая — мы заботимся о её здоровье, используем натуральные удобрения
                и соблюдаем севооборот. Благодаря этому наши овощи обладают тем самым вкусом,
                который многие помнят из детства.
              </p>
            </div>

            <div className="relative h-80 rounded-2xl overflow-hidden shadow-xl hover-lift">
              <Image
                src="/images/gallery-5.jpg"
                alt="Наша ферма"
                fill
                className="object-cover"
              />
              <div className="absolute inset-0 bg-gradient-to-t from-farm-green/30 to-transparent"></div>
            </div>
          </div>

          <div className="grid grid-cols-2 md:grid-cols-4 gap-6 mt-16 max-w-4xl mx-auto">
            <div className="text-center p-6 bg-farm-cream rounded-2xl">
              <div className="text-4xl mb-2">🌱</div>
              <div className="text-2xl font-bold text-farm-green">100%</div>
              <div className="text-sm text-farm-earth">Натурально</div>
            </div>
            <div className="text-center p-6 bg-farm-cream rounded-2xl">
              <div className="text-4xl mb-2">👨‍👩‍👧‍👦</div>
              <div className="text-2xl font-bold text-farm-green">Семья</div>
              <div className="text-sm text-farm-earth">Традиции</div>
            </div>
            <div className="text-center p-6 bg-farm-cream rounded-2xl">
              <div className="text-4xl mb-2">🌿</div>
              <div className="text-2xl font-bold text-farm-green">Эко</div>
              <div className="text-sm text-farm-earth">Подход</div>
            </div>
            <div className="text-center p-6 bg-farm-cream rounded-2xl">
              <div className="text-4xl mb-2">❤️</div>
              <div className="text-2xl font-bold text-farm-green">Забота</div>
              <div className="text-sm text-farm-earth">О каждом</div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}
